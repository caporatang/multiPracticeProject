# 원자적 연산
원자적 연산은 중단되지 않고, 다른 연산과 간섭 없이 완전히 실행되거나 전혀 실행되지 않는 성질을 가지고 있다. 멀티 스레드 상황에서 다른 스레드의 간섭 없이 안전하게 처리되는 연산이라는 뜻이다.  
````java
volatile int i = 0;

// 원자적 연산 -> 여러 스레드가 접근해도 i에 값만 할당하니까 문제 없다.
i = 1;
// 원자적 연산이 아니다 -> 여러 스레드가 동시에 접근하면 문제가 생길 수 있다.
i = i + 1; 
````
## Java에서 제공하는 Atomic 객체 성능 비교
- BasicInteger -> 아무 키워드, 아무것도 사용하지 않고 int값을 증가 시킨다.
- VolatileInteger -> 메모리 가시성을 비교 하기 위해 int 변수에 Volatile 키워드만 추가하고 int 값을 증가시킨다.
- SyncInteger -> increment, get 메서드에 Synchronized 키워드를 사용해서 동기화 시킨 상태에서 int 값을 증가 시킨다.
- BasicAtomicInteger -> Java에서 제공하는 AtomicInteger를 사용해서 int값을 증가시킨다.
````java
public class IncrementThreadMain {
    public static final int THREAD_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SyncInteger());
        test(new BasicAtomicInteger());
    }

    private static void test(IncrementInteger incrementInteger) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sleep(10);
                incrementInteger.increment();
            }
        };
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int result = incrementInteger.get();
        System.out.println(incrementInteger.getClass().getSimpleName() + " result: " + result);

    }
}
````
위 코드는 1억번을 단순하게 증가시키는 메서드이다. 각 인스턴스의 메서드를 호출하고 join으로 결과를 대기한 후 아래에서 걸린 시간을 출력한다.  
코드 실행 결과는 다음과 같다
````text
BasicInteger: ms=10
VolatileInteger: ms=694
SyncInteger: ms=1332
BasicAtomicInteger: ms=704
````
1. BasicInteger : CPU 캐시를 사용하기 때문에 가장 빠르지만, 단일 스레드가 아닌 멀티 스레드 환경 기준이기 때문에 가시성 문제가 생긴다. 
2. VolatileInteger : 임계 영역이 없기 때문에 멀티 스레드 상황에서는 사용할 수 없다, 그렇다고 단일 스레드 환경에서는 BasicInteger 보다 성능이 나오지 않는다.
3. SyncInteger : 임계 영역에서 사용하고 동기화해서 멀티 스레드에서 사용할 수 있다. 하지만 AtomicInteger 보다 성능이 느리다.
4. BasicAtomicInteger : 멀티 스레드에서 안전하게 사용 가능하고, 성능도 synchronized를 사용하는 것보다 거의 2배정도 빠르다.  
  
Atomic 객체를 사용하는게 왜 Synchronized 보다 성능이 빠른 이유는 Atomic 객체는 lock을 사용하지 않고 원자적 연산을 만들어 내기 때문이다.

