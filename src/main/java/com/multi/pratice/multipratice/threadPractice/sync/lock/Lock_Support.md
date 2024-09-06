# Lock support
Lock support는 synchronized의 단점을 보완하기 위해 Java1.5부터 추가된 라이브러리 패키지다.  
- synchronized의 단점은
  1. 무한대기
     - 특정 시간까지만 대기하는 타임아웃X
     - 중간에 인터럽트X
  2. 공정성
     - 락이 돌아왔을 때 BLOCKED 상태의 여러 스레드 중에 어떤 스레드가 락을 획득할 지 알 수 없어서 특정 스레드는 오랜기간 동안 락을 획득하지 못할 수 있다.

## Lock Support의 기능
LockSupport는 스레드를 WAITING 상태로 변경한다. WAITING 상태는 누군가가 다시 상태를 변경하지 않으면 계속 대기상태고 CPU 실행 스케줄링에 들어가지 않는다.
1. park() : 스레드를 WAITING 상태로 변경한다.
   - 스레드를 대기 상태로 둔다. 
2. parkNanos(nanos) : 스레드를 나노초 동안만 TIMED_WAITING 상태로 변경한다.
   - 지정한 나노초가 지나면 TIMED_WAITING 상태에서 빠져나오고 RUNNABLE 상태로 변경된다.
3. unpark(thread) : WAITING 상태의 대상 스레드를 RUNNABLE 상태로 변경한다.


## park(), unpark()
````java
public class LockSupportMainV1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new ParkTest(), "Thread-1");
        thread.start();

        sleep(1000);
        log("Thread-1 state : " + thread.getState());

        log("main -> unpark(Thread-1)");

        // unpark()
        // LockSupport.unpark(thread); 
        
        // interrupt()
        thread.interrupt();

    }

    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태 : " + Thread.currentThread().isInterrupted());
        }
    }
}
````
````text
[ Thread-1] park 시작
[     main] Thread-1 state : WAITING
[     main] main -> unpark(Thread-1)
[ Thread-1] park 종료, state: RUNNABLE
[ Thread-1] 인터럽트 상태 : false
````
main 스레드가 thread-1을 start하면 스레드의 상태는 RUNNABLE이다. 그리고 park를 호출하는 시점에 WAITING으로 변경되고, 대기한다. main 스레드가 unpark을 호출하는 순간 다시 RUNNABLE 상태로 변경된다.

WAITING 상태의 스레드에 인터럽트가 발생하면 WAITING 상태에서 RUNNABLE 상태로 변하면서 깨어난다.
````text
[ Thread-1] park 시작
[     main] Thread-1 state : WAITING
[     main] main -> unpark(Thread-1)
[ Thread-1] park 종료, state: RUNNABLE
[ Thread-1] 인터럽트 상태 : true
````
## parkNanos(nanos)
스레드를 나노초 동안만 TIMED_WAITING 상태로 변경한다. 지정한 나노초가 지나면 TIMED_WAITING 상태에서 빠져나와서 RUNNABLE 상태로 변경된다.  
````java
public static void main(String[] args) {
        Thread thread = new Thread(new ParkTest(), "Thread-1");
        thread.start();

        sleep(100);
        log("Thread-1 state : " + thread.getState());
    }

    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");

            // 2초 뒤에 깨어남
            LockSupport.parkNanos(2000_000000);

            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태 : " + Thread.currentThread().isInterrupted());
        }
    }
````
````text
46.455 [ Thread-1] park 시작
46.455 [     main] Thread-1 state : RUNNABLE
48.474 [ Thread-1] park 종료, state: RUNNABLE
48.498 [ Thread-1] 인터럽트 상태 : false
````
## BLOCKED vs WAITING
BLOCKED 상태는 인터럽트가 걸려도 대기 상태를 빠져나오지 못한다. 여전히 BLOCKED 상태이고 WAITING, TIMED_WAITING 상태는 인터럽트가 걸리면 대기 상태를 빠져나온다. 그래서 RUNNABLE 상태로 변경된다.  
- 용도 
  - BLOCKED 상태는 synchronized 에서 락을 획득하기 위해 대기할 때 사용된다.
  - WAITING, TIMED_WAITING 상태는 스레드가 특정 조건이나 시간 동안 대기할 때 발생하는 상태다.
  - WAITING 상태는 다양한 상황에서 사용된다. Thread.join(), LockSupport.park(), Object.wait() 이런 메서드를 사용할 때 WAITING 상태가 된다.
  - TIMED_WAITING 상태는 Thread.sleep(ms), Object.wait(long timeout), Thread.join(long millis), LockSupport.parkNanos(ns) 등과 같은 시간 제한이 있는 대기 메서드를 호출할 때 발생한다.

BLOCKED, WAITING, TIMED_WAITING 상태 모두 스레드가 대기하며, 실행 스케줄링에 들어가지 않기 떄문에, CPU 입장에서 보면 실행하지 않는 비슷한 상태이다. BLOCKED는 synchronized에서만 사용하는 특별한 대기 상태라고 이해하면 되고, WAITING, TIMED_WAITING 상태는 범용적으로 활용할 수 있는 대기 상태다.

## synchronized의 단점 극복 
synchronized의 단점은 무한대기다. 무한 대기는 BLOCKED 상태의 스레드는 락이 풀릴 때 까지 무한 대기하는 상태인데, 특정 시간까지만 대기하는 LockSupport.parkNanos(), 중간에 인터럽트를 사용할 수 없는 문제는 park(), parkNanos() 를 사용하면 된다.  
당연히 무작정 사용하면 되는건 아니고, LockSupport를 활용해서 임계 영역을 만드는 어떤 기능을 개발해야 한다.

```java
import com.multi.pratice.multipratice.threadPractice.util.MyLogger;

import java.util.concurrent.locks.LockSupport;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.*;

public class LockTest {
    public LockTestMethod() {
        /* do something .. */
        if (!lock.trylock()) { // 내부에서 parkNanos() 사용
            log("진입 실패 -> 오래 대기 했습니다");
            return false;
        }
        /* 임계 영역 시작 */

        /* do something .. */

        /* 임계 영역 종료 */

        lock.unlock(); // 내부에서 unpark() 사용
    }
}
```
lock 이라는 클래스를 만들고, 특정 스레드가 먼저 락을 얻으면 RUNNABLE로, 락을 얻지 못하면 park()를 사용해서 대기 상태로 만든다.  
그리고 스레드가 임계 영역의 실행을 마치고 나면 락을 반납하고, unpark()를 사용해서 대기 중인 다른 스레드를 깨운다.  
이런 기능을 직접 구현하기는 어렵다. 스레드 10개를 동시 실행 했는데 딱 1개의 스레드만 락을 가질 수 있도록 락 기능을 만들어야 하는데, 나머지 9개의 스레드는 대기 상태이다. 어떤 스레드가 대기하고 있는지 알 수 있는 자료 구조가 필요하다. 대기 중인 어떤 스레드를 깨울지에 대한 우선순위에 대한 결정도 필요하다.  

자바는 이런 기능을 지원하기 위해 LockSupport 보다 고수준인 Lock 인터페이스와 ReentrantLock 이라는 구현체를 제공한다.
ReentrantLock은 LockSupport를 활용해서 synchronized의 단점을 극복할 수 있고, 편하게 임계 영역을 다룰 수 있는 기능을 제공한다.