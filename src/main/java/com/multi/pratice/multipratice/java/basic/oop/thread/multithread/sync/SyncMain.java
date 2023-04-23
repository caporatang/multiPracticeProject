package com.multi.pratice.multipratice.java.basic.oop.thread.multithread.sync;

import com.multi.pratice.multipratice.springbasic.aop.aopp.ParameterAop;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.thread.multithread.sync
 * fileName : SyncMain
 * author : taeil
 * date : 2023/04/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/23        taeil                   최초생성
 */
@Getter
@Setter
class Bank {
    // Bank 클래스는 돈을 더하거나 빼는 역할을 한다.

    // synchronized -> 동기화 키워드
    // synchronized를 사용하지 않으면, 아래에서 saveMoney 메서드를 호출하는 경우, 중간에 sleep(3000) 하는동안
    // minus 메서드가 호출이되어 saveMoney가 끝나기전에 minus 연산을 실행한다.
    // 하나의 스레드가 동작을 수행하는 동안 다른 스레드를 lock을 걸어주는 기능이 synchronized 이다.

    private int money = 10000;

    public void saveMoney(int save) throws InterruptedException {

        // synchronized 사용 방법
        // 1. 메서드에 synchronized 를 붙여주는 방법 -> minusMoney()
        // 2. synchronized 블럭 처리 -> saveMoney()

        synchronized (this) {
            // 사용한 메서드가 수행되는 동안 매개변수로 주어지는 객체에 lock
            int m = getMoney();
            Thread.sleep(3000); // + 는 3초

            setMoney(m + save);
        }
    }

    public synchronized void minusMoney(int minus) throws InterruptedException {
        int m = getMoney();
        Thread.sleep(2000); // - 는 2초

        setMoney(m - minus);
    }

}

class Taeil extends Thread {

    public void run() {
        // Thread에도 걸수있음 -> shared resource는 SyncMain.myBank
        // synchronized (SyncMain.myBank) {
        //    System.out.println("start save");
        //    try {
        //        SyncMain.myBank.saveMoney(3000); // -> main 메서드 안에 공통 자원으로 생성해둔 뱅크에 접근.
        //    } catch (InterruptedException e) {
        //        throw new RuntimeException(e);
        //    }
        //    System.out.println("saveMoney(3000) : " + SyncMain.myBank.getMoney());
        //}

        System.out.println("start save");
        try {
            SyncMain.myBank.saveMoney(3000); // -> main 메서드 안에 공통 자원으로 생성해둔 뱅크에 접근.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("saveMoney(3000) : " + SyncMain.myBank.getMoney());
    }
}

class TaeilBro extends Thread {
    public void run() {
        System.out.println("start minus");
        try {
            SyncMain.myBank.minusMoney(1000); // -> main 메서드 안에 공통 자원으로 생성해둔 뱅크에 접근.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("minusMoney(1000) : " + SyncMain.myBank.getMoney());
    }
}

public class SyncMain {

    public static Bank myBank = new Bank();

    public static void main(String[] args) {
        Taeil taeil = new Taeil();
        taeil.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TaeilBro taeilBro = new TaeilBro();
        taeilBro.start();
    }

    // synchronized 사용 전 결과
    // start save
    // start minus
    // minusMoney(1000) : 9000
    // saveMoney(3000) : 13000

    // synchronized 키워드 사용 후 결과
    // start save
    // start minus
    // saveMoney(3000) : 13000
    // minusMoney(1000) : 12000

    // -> synchronized 사용 시 saveMoney 의 ThreadSleep이 다 끝난 후 minusMoney 수행.

    // 결과적으로 minus를 먼저 수행하던, save를 먼저 수행하던 중요한건 공유하는 리소스(Bank)에 접근해서 무언가 처리할 때,
    // 다른 메서드는 lock이 걸려서 공유하는 리소스의 값에 문제가 생기지 않는다.
}