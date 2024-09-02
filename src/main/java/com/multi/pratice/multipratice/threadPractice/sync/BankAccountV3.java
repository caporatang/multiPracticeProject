package com.multi.pratice.multipratice.threadPractice.sync;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.log;
import static com.multi.pratice.multipratice.threadPractice.util.ThreadUtils.sleep;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.sync
 * fileName : BankAccountV1
 * author : taeil
 * date : 2024. 9. 2.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 2.        taeil                   최초생성
 */
public class BankAccountV3 implements BankAccount {

    private int balance;

    public BankAccountV3(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public  boolean withdraw(int amount) {

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