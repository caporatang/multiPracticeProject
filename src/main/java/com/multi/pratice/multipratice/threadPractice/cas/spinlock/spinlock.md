# CAS
CAS는 단순한 연산 뿐만 아니라, synchronized, Lock(ReentrantLock) 없이 락을 구현하는데 사용할 수도 있다.  
스레드를 대기없이 lock을 구현하는 방법인데, 이를 spinlock이라고 한다.  

````java
public class SpinLockBad {

    private volatile boolean lock = false;

    public void lock() {
        log("락 획득 시도");
        while (true) {
            if (!lock) { // 락 사용 여부 확인
                sleep(100); // 문제 상황 확인, 스레드 대기
                lock = true; // 어떤 스레드가 락을 획득한 경우 true
                break;
            }  else {
                // 락을 획득할 때 까지 스핀 대기
                log("락 획득 실패 - 스핀 대기");
            }
        }
        log("락 획득 완료");
    }

    public void unlock() {
        lock = false;
        log("락 반납 완료");
    }

}
````
````text
> Task :com.multi.pratice.multipratice.threadPractice.cas.spinlock.SpinLockMain.main()
[ Thread-1] 락 획득 시도
[ Thread-2] 락 획득 시도
[ Thread-2] 락 획득 완료
[ Thread-1] 락 획득 완료
[ Thread-2] 비즈니스 로직 실행
[ Thread-1] 비즈니스 로직 실행
[ Thread-2] 락 반납 완료
[ Thread-1] 락 반납 완료
````
코드의 실행 결과를 보면 스레드 하나씩 락을 획득하는게 아니라 동시에 획득 부터 반납까지 실행이된다. 이렇게 실행되는 이유는 스레드가 동시에 실행되었기 때문이다.  
락 사용 여부를 확인하는 부분, 락의 값을 변경하는 부분 이 두 부분이 원자적이지 않다는 문제가 있다. 이 두 부분은 한 번에 하나의 스레드만 실행해야 한다. 그래서 사용하는게 synchronized, Lock 을 사용해서 임계영역을 안전하게 만들어야한다.

다른 해결 방안으로 두 코드를 하나로 묶어서 원자적으로 처리하는 방법인데, CAS 연산을 사용하면 두 연산을 하나로 묶어서 하나의 원자적인 연산으로 처리할 수 있다.  
락의 사용 여부를 확인하고 그 값이 기대하는 값과 같다면 변경한다. 

````java
public class SpinLock {

    private final AtomicBoolean lock = new AtomicBoolean(false);

    public void lock() {
        log("락 획득 시도");
        while (!lock.compareAndSet(false, true)) {
            // lock의 값이 false면 -> lock을 획득한 스레드가 없다면
            // lock의 값을 true로 변경한다 -> 락을 획득한 스레드가 있다.
            log("락 획득 실패 - 스핀 대기");

        }
        log("락 획득 완료");
    }

    public void unlock() {
        lock.set(false);
        log("락 반납 완료");
    }
}
````
CAS 연산을 지원하는 AtomicBoolean을 사용해서 구현한 코드다.  
스레드가 락을 획득하면 lock의 값은 true가 되고, 스레드가 락을 반납하면 lock의 값이 false가 된다.  

````text
[ Thread-1] 락 획득 시도
[ Thread-2] 락 획득 시도
[ Thread-2] 락 획득 완료
[ Thread-1] 락 획득 실패 - 스핀 대기
[ Thread-2] 비즈니스 로직 실행
[ Thread-1] 락 획득 실패 - 스핀 대기
[ Thread-2] 락 반납 완료
[ Thread-1] 락 획득 완료
[ Thread-1] 비즈니스 로직 실행
[ Thread-1] 락 반납 완료
````

원자적인 연산은 스레드 입장에서는 나눌 수 없는 하나의 연산이다. 이는 여러 스레드가 동시에 실행해도 안전하다.
CAS를 사용하면 동기화 락을 사용해서 락을 획득하지 못하면 BLOCKED, WAITING 등으로 상태를 변경하고 대기 상태의 스레드를 깨워야 하는 비교적 무거운 과정 없이 스레드의 상태도 RUNNABLE로 유지하면서 비교적 가볍고 빠르게 락을 구현할 수 있다.  

## CAS 락 단점
CAS락은 무조건 장점만 있는 것은 아니다. 하나의 스레드가 락을 획득하고 비즈니스 로직을 길게 수행하는 경우, 나머지 스레드는 while문 안에서 계속해서 체크하게 된다. 스레드의 수가 적으면 비교적 문제가 되지 않겠지만 스레드의 갯수가 많이 필요한 경우 CPU를 계속 사용해야한다.  
그래서 CAS락은 임계 영역은 필요한데, 연산은 짧게 끝나는 경우 사용해야 한다. 숫자 값의 증가, 자료 구조의 데이터 추가 등.. DB를 기다린다거나 다른 서버의 요청을 기다린다거나 할 때 사용하면 계속해서 대기하기 때문에 CPU의 부하가 심해진다.  

## 정리
스레드가 락을 획득 할 때 까지 while 안에서 계속해서 스핀 대기(spin-wait) 또는 CPU 자원을 계속 사용하면서 바쁘게 대기한다고 해서 바쁜 대기(busy-wait)라 한다. 스핀 락 방식은 아주 짧은 CPU 연산을 할 때 사용해야 효율적이고, 잘못 사용하면 오히려 CPU 자원을 더 많이 사용할 수 있다.  
스핀 락은 락을 획득하기 위해 자원을 소모하면서 반복적으로 확인하는 락 메커니즘을 뜻하고 이런 스핀락은 CAS를 사용해서 구현한다.



