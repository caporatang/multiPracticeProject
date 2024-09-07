package com.multi.pratice.multipratice.threadPractice.sync.lock;

import com.multi.pratice.multipratice.threadPractice.sync.BankAccount;
import com.multi.pratice.multipratice.threadPractice.sync.BankAccountV2;
import com.multi.pratice.multipratice.threadPractice.sync.WithdrawTask;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.log;
import static com.multi.pratice.multipratice.threadPractice.util.ThreadUtils.sleep;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.sync
 * fileName : BankMain
 * author : taeil
 * date : 2024. 9. 2.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 2.        taeil                   최초생성
 */
public class BankMain {
    public static void main(String[] args) throws InterruptedException {
        //BankAccount account = new BankAccountV4(1000);
        //BankAccount account = new BankAccountV5(1000);
        BankAccount account = new BankAccountV6(1000);

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