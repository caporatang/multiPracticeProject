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