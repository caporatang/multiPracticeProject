# synchronized
멀티스레드를 사용할 때 가장 주의해야 할 점은, 같은 리소스에 여러 스레드가 동시에 접근할 때 발생하는 동시성 문제다. 여러 스레드가 접근하는 자원을 공유 자원이라 하고, 멀티스레드를 사용할 때는 이런 공유 자원에 대한 접근을 적절하게 동기화(synchronized)해서 동시성 문제가 발생하지 않게 방지 해야 한다.

````java
public class BankAccountV1 implements BankAccount {

    private int balance;

    public BankAccountV1(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {

        log("거래 시작 " + getClass().getSimpleName());

        log("[검증 시작] 출금액 : " + amount + ", 잔액 : " + balance);
        // 잔고가 출금액 보다 적으면, 진행 x
        if (balance < amount) {
            log("[검증 실패] 출금액 : " + amount + ", 잔액 : " + balance);
            return false;
        }
        log("[검증 완료] 출금액 : " + amount + ", 잔액 : " + balance);
        sleep(1000); // 출금에 걸리는 시간으로 가정한다.
        balance = balance - amount;

        log("[출금 완료] 출금액 : " + amount + ", 잔액 : " + balance);
        log("거래 종료 ");

        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}


public class BankMain {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccountV1(1000);

        Thread thread1 = new Thread(new WithdrawTask(account, 800), "t1");
        Thread thread2 = new Thread(new WithdrawTask(account, 800), "t2");

        thread1.start();
        thread2.start();

        sleep(500); // 검증 완료까지 잠시 대기
        log("thread1 state : " + thread1.getState());
        log("thread2 state : " + thread2.getState());

        thread1.join();
        thread2.join();

        log("최종 잔액 : " + account.getBalance());
    }
}
````
은행의 입출금 이라고 가정하면, 스레드 2개가 1000원의 잔고를 가진 계좌에서 800원을 동시에 출금하려고 시도하는 코드다.
검증 로직을 보면 잔고가 출금액보다 많으면 false를 반환하고 로직이 진행되지 않게끔 막아놨지만 실행 결과는 t1, t2 스레드 모두 출금되고, 최종 잔액은 200원으로 800원이 공중 분해 됐다.
````text
10:21:54.150 [       t2] 거래 시작 BankAccountV1
10:21:54.150 [       t1] 거래 시작 BankAccountV1
10:21:54.193 [       t1] [검증 시작] 출금액 : 800, 잔액 : 1000
10:21:54.193 [       t2] [검증 시작] 출금액 : 800, 잔액 : 1000
10:21:54.195 [       t1] [검증 완료] 출금액 : 800, 잔액 : 1000
10:21:54.195 [       t2] [검증 완료] 출금액 : 800, 잔액 : 1000
10:21:54.485 [     main] thread1 state : TIMED_WAITING
10:21:54.486 [     main] thread2 state : TIMED_WAITING
10:21:55.203 [       t1] [출금 완료] 출금액 : 800, 잔액 : 200
10:21:55.204 [       t2] [출금 완료] 출금액 : 800, 잔액 : 200
10:21:55.207 [       t1] 거래 종료 
10:21:55.208 [       t2] 거래 종료 
10:21:55.231 [     main] 최종 잔액 : 200
````

## 임계 영역 (critical section)
임계 영역은 여러 스레드가 동시에 접근하면 데이터 불일치나 예상치 못한 동작이 발생할 수 있는 위험하고 또 중요한 코드 부분을 하며, 여러 스레드가 동시에 접근해서는 안 되는 공유 자원에 접근하거나 수정하는 부분을 의미한다.  

위 예제 코드 같은 문제는 여러 스레드가 함께 사용하는 공유 자원을 여러 단계로 나눠서 사용하기 때문에 발생한다.
1. 검증 단계 : 잔액 확인
2. 출금 단계 : 잔액 감소  
위 코드의 로직은 내가 사용하는 값이 중간에 변경되지 않을 것이라는 가정이 깔려있다. 그런데, 중간에 다른 스레드가 잔액의 값을 변경한다면 큰 혼란이 생긴다.

공유자원인 balance를 한 번에 하나의 스레드만 값을 변경할 수 있게끔 하는것이 중요하다. 위 로직 기준으로 검증과 출금 두가지 로직이 한번에 하나의 스레드만 수행할 수 있게끔 해야한다.
이럴때 사용하는게 synchronized 다.


````java
public class BankAccountV2 implements BankAccount {

    private int balance;

    public BankAccountV2(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public synchronized boolean withdraw(int amount) {

        log("거래 시작 " + getClass().getSimpleName());

        log("[검증 시작] 출금액 : " + amount + ", 잔액 : " + balance);
        // 잔고가 출금액 보다 적으면, 진행 x
        if (balance < amount) {
            log("[검증 실패] 출금액 : " + amount + ", 잔액 : " + balance);
            return false;
        }
        log("[검증 완료] 출금액 : " + amount + ", 잔액 : " + balance);
        sleep(1000); // 출금에 걸리는 시간으로 가정한다.
        balance = balance - amount;

        log("[출금 완료] 출금액 : " + amount + ", 잔액 : " + balance);
        log("거래 종료 ");

        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
````
````text
10:56:02.553 [       t1] 거래 시작 BankAccountV2
10:56:02.575 [       t1] [검증 시작] 출금액 : 800, 잔액 : 1000
10:56:02.576 [       t1] [검증 완료] 출금액 : 800, 잔액 : 1000
10:56:02.889 [     main] thread1 state : TIMED_WAITING
10:56:02.890 [     main] thread2 state : BLOCKED
10:56:03.584 [       t1] [출금 완료] 출금액 : 800, 잔액 : 200
10:56:03.585 [       t1] 거래 종료 
10:56:03.589 [       t2] 거래 시작 BankAccountV2
10:56:03.592 [       t2] [검증 시작] 출금액 : 800, 잔액 : 200
10:56:03.593 [       t2] [검증 실패] 출금액 : 800, 잔액 : 200
10:56:03.619 [     main] 최종 잔액 : 200
````
synchronized를 추가하면 스레드 하나씩 접근해서 정상적으로 검증되는 것을 확인할 수 있다.    
그리고 t2 스레드의 상태를 보면 BLOCKED 상태인것을 확인할 수 있는데, 모든 객체(인스턴스) 내부에는 자신만의 lock을 가지고 있는데 이 lock은 모니터 락(monitor lock) 이라고도 부른다. synchronized 키워드가 있는 메서드에 진입하려면 반드시 해당 인스턴스(접근 하려는 객체)의 lock이 있어야한다.

1. t1 스레드가 BankAccount 객체의 lock을 획득하고 withdraw() 메서드에 접근한다.
2. t2 스레드도 BankAccount 객체의 withdraw() 메서드에 접근을 시도한다, lock은 t1 스레드가 획득한 상태이기 때문에 lock을 획득할 때 까지 (t1 스레드가 작업을 다 하고 lock을 반환할 때까지) BLOCKED 상태로 대기한다.
3. BLOCKED 상태로 변경되면 락을 다시 획득하기 전까지는 계속 대기하고, CPU 실행 스케줄링에서 제외된다.

## synchronized 코드 블럭
synchronized 의 단점이자 장점은 한 번에 하나의 스레드만 실행할 수 있다는 점이다. 따라서 synchronized를 통해 동시에 실행할 수 없는 코드 구간은 꼭 필요한 곳에만 사용해야한다.
즉, 임계 영역을 정확히 구분하고 꼭 필요한 부분에만 사용해야 한다.

````java
public class BankAccountV3 implements BankAccount {

    private int balance;

    public BankAccountV3(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {

        log("거래 시작 " + getClass().getSimpleName());

        synchronized (this) {
            // this를 사용해서 Lock 해당 인스턴스의 Lock을 획득
            // 임계 영역에만 적용
            log("[검증 시작] 출금액 : " + amount + ", 잔액 : " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액 : " + amount + ", 잔액 : " + balance);
                return false;
            }
            log("[검증 완료] 출금액 : " + amount + ", 잔액 : " + balance);
            sleep(1000);
            balance = balance - amount;

            log("[출금 완료] 출금액 : " + amount + ", 잔액 : " + balance);
        }
        log("거래 종료 ");

        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
````

## 정리
동기화는 여러 스레드가 동시에 접근할 수 있는 자원에 대해 일관성 있고 안전한 접근을 보장하기 위한 메커니즘이다. 주로 멀티스레드 환경에서 발생할 수 있는 문제, 예를 들어 데이터 손상이나 예기치 않은 결과를 방지한다.
이러한 동기화를 사용하면 경합 조건과 데이터 일관성 문제를 해결할 수 있다.  
1. 경합 조건 (Race condition) : 두 개 이상의 스레드가 경쟁적으로 동일한 자원을 수정할 때 발생하는 문제
2. 데이터 일관성 : 여러 스레드가 동시에 읽고 쓰는 데이터의 일관성을 유지
