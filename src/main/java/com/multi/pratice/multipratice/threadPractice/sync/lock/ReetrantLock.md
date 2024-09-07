# ReetrantLock
자바 1.0부터 지원하기 시작한 synchronized와 BLOCKED 상태를 통한 임계 영역 관리의 한계를 극복하기 위해 자바 1.5부터 Lock 인터페이스, ReentrantLock 구현체를 제공한다.  

````java
package java.util.concurrent.locks;

import java.util.concurrent.TimeUnit;

public interface Lock {
    void lock();
    void lockInterruptibly() throws InterruptedException;
    boolean tryLock();
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
    void unlock();
    Condition newCondition();
}
````
Lock 인터페이스는 안전한 임계 영역을 위한 락을 구현하는데 사용한다.

- void lock()
    - 락을 획득한다. 만약 다른 스레드가 이미 락을 획득했다면, 락이 풀릴 때까지 현재 스레드는 대기한다. 이 메서드는 인터럽트에 응답하지 않는다.
      - 여기서 뜻하는 락은 객체 내부에 있는 모니터 락이 아니다. Lock 인터페이스와 ReentrantLock 이 제공하는 기능이다. 모니터 락과 BLOCKED 상태는 synchronized 에서만 사용된다.
- void lockInterruptibly()
  - 락 획득을 시도하지만, 다른 스레드가 인터럽트할 수 있도록 한다. 만약 다른 스레드가 이미 락을 획득했다면, 현재 스레드는 락을 획득할 때까지 대기하고, 대기 중 인터럽트가 발생하면 InterruptedException이 발생하며 락 획득을 포기한다.
- boolean tryLock()
  - 락 획득을 시도하고, 즉시 성공 여부를 반환한다. 만약 다른 스레드가 이미 락을 획득했다면 false, 그렇지 않으면 true를 반환한다.
- boolean tryLock(long time, TimeUnit unit)
  - 주어진 시간 동안 락 획득을 시도, 시간 안에 락을 획득하면 true를 반환한다. 획득하지 못하면 false를 반환한다. 대기 중 인터럽트가 발생하면 InterruptedException이 발생하며 락 획득을 포기한다.
- void unlock()
  - 락을 해제한다. 락을 해제하면 락 획득을 대기 중인 스레드 중 하나가 락을 획득할 수 있게 된다. 락을 획득한 스레드가 호출해야 하며, 그렇지 않으면 IllegalMonitorStateException이 발생한다.
- Condition newCondition()
  - Condition 객체를 생성하여 반환한다. Condition 객체는 락과 결합되어 사용되며, 스레드가 특정 조건을 기다리거나 신호를 받을 수 있도록 한다. 

## 공정성
Lock 인터페이스의 대표적인 구현체로 ReetrantLock을 사용하면 공정하게 스레드를 획득할 수 있게끔 설정할 수 있다.

````java
import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockTest {
    // 비공정 모드 락
    private final Lock nonFairLock = new ReentrantLock();
    
    // 공정 모드 락 
    private final Lock fairLock = new ReetrantLock(true);
    
    public void nonFairLockTest() {
        nonFairLock.lock();
        try {
            /* 임계영역 do something .. */
        } finally {
          nonFairLock.unlock();
        }
    }

  public void nonFairLockTest() {
    fairLock.lock();
    try {
      /* 임계영역 do something .. */
    } finally {
      fairLock.unlock();
    }
  }
}
````
비공정 모드는 락을 획득하는 속도가 빠르고, 새로운 스레드가 기존 대기 스레드보다 먼저 락을 획득할 수 있다. 기아 현상이 발생할 수 있는데, 기아 현상은 특정 스레드가 계속해서 락을 획득하지 못할 수 있는 현상을 뜻한다.  
반대로 공정 모드는 락을 요청한 순서대로 스레드가 락을 획득할 수 있게 한다. 대기 큐에서 먼저 대기한 스레드가 락을 먼저 획득하고, 기아 현상이 방지 된다는 특징이 있지만 성능이 떨어질 수 있다.  

## ReentrantLock의 활용
````java
public class BankAccountV4 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV4(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public  boolean withdraw(int amount) {
        log("거래 시작 " + getClass().getSimpleName());

        lock.lock(); // ReentrantLock을 이용하여 lock

        try {
            log("[검증 시작] 출금액 : " + amount + ", 잔액 : " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액 : " + amount + ", 잔액 : " + balance);
                return false;
            }
            log("[검증 완료] 출금액 : " + amount + ", 잔액 : " + balance);

            sleep(1000);
            balance = balance - amount;

            log("[출금 완료] 출금액 : " + amount + ", 잔액 : " + balance);
        } finally {
            // lock을 사용했으면 반드시 unlock
            // 에러가 터지거나 다른 문제가 생겼을 때도 반드시 unlock이 되어야 하므로 try - finally 사용
            lock.unlock();
        }
        log("거래 종료 ");

        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
````
````text
17:58:45.523 [       t1] 거래 시작 BankAccountV4
17:58:45.523 [       t2] 거래 시작 BankAccountV4
17:58:45.549 [       t1] [검증 시작] 출금액 : 800, 잔액 : 1000
17:58:45.550 [       t1] [검증 완료] 출금액 : 800, 잔액 : 1000
17:58:45.821 [     main] thread1 state : TIMED_WAITING
17:58:45.821 [     main] thread2 state : WAITING
17:58:46.557 [       t1] [출금 완료] 출금액 : 800, 잔액 : 200
17:58:46.558 [       t1] 거래 종료 
17:58:46.558 [       t2] [검증 시작] 출금액 : 800, 잔액 : 200
17:58:46.562 [       t2] [검증 실패] 출금액 : 800, 잔액 : 200
17:58:46.574 [     main] 최종 잔액 : 200
````
synchronized 보다 더 유연하게 사용할 수 있다. 다만, synchronized는 대기하는 스레드의 상태가 BLOCKED였고 ReentrantLock을 사용하면 대기하는 스레드의 상태는 WAITING이다.  

## 대기 중단
tryLock(), tryLock(long time, TimeUnit unit) 을 사용하면 대기를 중간에 중단시킬 수 있다.
````java
public class BankAccountV5 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV5(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public  boolean withdraw(int amount) {
        log("거래 시작 " + getClass().getSimpleName());

        if (!lock.tryLock()) {
            // 획득할 lock이 없는 경우 바로 return
            log("[진입 실패] 이미 처리중인 작업 존재");
            return false;
        }
        
      // 시간 지정
      //try {
      //  if (!lock.tryLock(500, TimeUnit.MILLISECONDS)) {
      //    // 0.5초간 대기하다가 락을 획득하지 못하면 false를 반환하면서 메서드를 빠져나옴
      //    // 스레드의 상태는 대기하는 동안 TIMED_WAITING, 대기 상태를 빠져나오면 RUNNABLE
      //    log("[진입 실패] 이미 처리중인 작업 존재");
      //    return false;
      //  }
      //} catch (InterruptedException e) {
      //  throw new RuntimeException(e);
      //}
        
        try {
            log("[검증 시작] 출금액 : " + amount + ", 잔액 : " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액 : " + amount + ", 잔액 : " + balance);
                return false;
            }
            log("[검증 완료] 출금액 : " + amount + ", 잔액 : " + balance);

            sleep(1000);
            balance = balance - amount;

            log("[출금 완료] 출금액 : " + amount + ", 잔액 : " + balance);
        } finally {
            lock.unlock();
        }
        log("거래 종료 ");

        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
````
````text
시간 지정하지 않은 결과
18:07:29.562 [       t1] 거래 시작 BankAccountV5
18:07:29.562 [       t2] 거래 시작 BankAccountV5
18:07:29.569 [       t2] [진입 실패] 이미 처리중인 작업 존재
18:07:29.587 [       t1] [검증 시작] 출금액 : 800, 잔액 : 1000
18:07:29.588 [       t1] [검증 완료] 출금액 : 800, 잔액 : 1000
18:07:29.878 [     main] thread1 state : TIMED_WAITING
18:07:29.880 [     main] thread2 state : TERMINATED
18:07:30.597 [       t1] [출금 완료] 출금액 : 800, 잔액 : 200
18:07:30.599 [       t1] 거래 종료 
18:07:30.618 [     main] 최종 잔액 : 200
````

````text
시간 지정해준 실행 결과
18:12:37.048 [       t1] 거래 시작 BankAccountV6
18:12:37.048 [       t2] 거래 시작 BankAccountV6
18:12:37.073 [       t1] [검증 시작] 출금액 : 800, 잔액 : 1000
18:12:37.074 [       t1] [검증 완료] 출금액 : 800, 잔액 : 1000
18:12:37.382 [     main] thread1 state : TIMED_WAITING
18:12:37.383 [     main] thread2 state : TIMED_WAITING
18:12:37.558 [       t2] [진입 실패] 이미 처리중인 작업 존재
18:12:38.082 [       t1] [출금 완료] 출금액 : 800, 잔액 : 200
18:12:38.087 [       t1] 거래 종료 
18:12:38.105 [     main] 최종 잔액 : 200
````