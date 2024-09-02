package com.multi.pratice.multipratice.threadPractice.sync;

public interface BankAccount {

    boolean withdraw(int amount); // 출금

    int getBalance(); // 잔고 확인
}
