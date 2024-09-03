# CAS 연산
lock 기반 방식(synchronized)의 문제점은 데이터를 보호하기 위해 락을 사용하게 된다. 락은 특정 자원을 보호하기 위해 스레드가 해당 자원에 대한 접근하는 것을 제한한다. 락이 걸려 있는 동안 다른 스레드들은 해당 자원에 접근할 수 없고, 락이 해제될 때까지 대기해야 한다. 그리고 락을 획득하고 반납하는 과정에서도 시간이 소요된다.  
1. 락이 있는지 확인한다.
2. 락을 획득하고 임계 영역에 들어간다.
3. 작업을 수행한다.
4. 락을 반납한다.  

1억번의 연산을 수행한다면 4가지 과정을 반복하게 된다. 이러한 문제를 해결하기 위해 락을 걸지 않고 원자적인 연산을 수행할 수 있는 방법이 CAS(Compare-And-Swap, Compare-And-Set) 연산이라 하고, 락을 사용하지 않기 때문에 lock-free 기법이라고도 한다.
  
````java
public class CasMainV1 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = " + atomicInteger.get());

        boolean result1 = atomicInteger.compareAndSet(0, 1);
        System.out.println("result1 = " + result1 + ", value = " + atomicInteger.get());

        boolean result2 = atomicInteger.compareAndSet(0, 1);
        System.out.println("result2 = " + result2 + ", value = " + atomicInteger.get());
    }
}
````
위 코드는 Atomic 객체에서 제공하는 CAS 연산 메서드이다. 그런데 저 메서드를 사용하는게 왜 원자적 연산인가?   
첫번째 인자는 기대하는 값, 두번째 인자는 변경할 값이다. 그렇다면 기대하는 값이 0이라면 값을 1로 변경하고 true/false를 반환해 라는 계산이 2번 실행이 되야하는데 어떻게 원자적 연산으로 처리할 수 있는걸까  
  
### 이유는 CPU의 하드웨어 지원 때문이다.
CAS 연산은 원자적이지 않은 두 개의 연산을 CPU 하드웨어 차원에서 하나의 원자적인 연산으로 묶어서 제공하는 기능으로, 소프트웨어가 제공하는 기능이 아니라 하드웨어가 제공하는 기능으로 CPU들은 CAS연산을 위한 명령어를 제공한다.  
CPU가 기대하는 값, 변경해야할 값을 확인하는 중간 과정 사이에 다른 스레드가 접근하지 못하도록 막아버린다. 즉, 2개의 연산을 하나의 연산으로 만들어서 처리해준다.


## CAS 연산의 동작 방식
AtomicInteger에서 제공하는 IncrementAndGet() 같은 메서드도 아래와 같은 방식으로 동작한다. CAS 연산을 사용하면 lock을 사용하지 않고 다른 스레드가 값을 먼저 증가해서 문제가 발생하는 경우 루프를 통해 값을 체크하고 재시도 하는 방식으로 동작한다.
````java
public class CasMainV3 {

    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println("start value = " + atomicInteger.get());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                incrementAndGet(atomicInteger);
            }
        };

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i <THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int result = atomicInteger.get();
        System.out.println(atomicInteger.getClass().getSimpleName() + " resultValue: " + result );
    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;

        do {
            getValue = atomicInteger.get();
            sleep(100); // 스레드 동시 실행을 위한 sleep
            log("getValue = " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
            log("result : " + result);
        } while (!result);

        return getValue + 1;
    }
}
````
````text
start value = 0
22:06:54.378 [ Thread-0] getValue = 0
22:06:54.378 [ Thread-1] getValue = 0
22:06:54.383 [ Thread-0] result : true
22:06:54.383 [ Thread-1] result : false
22:06:54.489 [ Thread-1] getValue = 1
22:06:54.489 [ Thread-1] result : true
AtomicInteger resultValue: 2
````
1. 현재 변수 값을 읽어온다.
2. 변수의 값을 1 증가시킬 때, 원래 값이 같은지 확인한다 (compareAndSet)
3. 동일하다면 증가된 값을 변수에 저장하고 종료한다.
4. 동일하지 않다면 확인하는 중간에 다른 스레드가 확인하는 값을 변경한 것이므로, 다시 처음으로 돌아가 과정을 반복한다.

## CAS의 단점 
여러개의 스레드가 동시에 실행되면서 문제가 되는 경우륾 스레드 충돌이라 하는데, 충돌이 빈번하게 발생하는 환경에서는 성능에 문제가 될 수 있다.  
여러 스레드가 빈번하게 충돌이 일어나는 경우 CAS는 당연히 자주 재시도를 하게 되면서 반복문이 여러번 실행되기 때문에 CPU 자원에 대한 소모가 클 수 있다.  

## CAS 와 Lock 방식 비교
- Lock
  - 비관적 접근법
  - 데이터에 접근하기 전에 항상 lock을 획득해야함
  - 다른 스레드의 접근을 막음
  - 다른 스레드가 방해할 것이다 라고 가정하고 접근하게 만듬
- CAS 
  - 낙관적 접근법
  - 락을 사용하지 않고 데이터에 바로 접근
  - 충돌이 발생하면 그때서야 재시도
  - 다른 스레드와 충돌하지 않을 것이다. 라고 가정

