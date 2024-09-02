package com.multi.pratice.multipratice.threadPractice.cas.increment;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.cas.increment
 * fileName : BasicInteger
 * author : taeil
 * date : 2024. 9. 2.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 2.        taeil                   최초생성
 */
public class SyncInteger implements IncrementInteger {

    private int value;

    @Override
    public synchronized int get() {
        return value;
    }

    @Override
    public synchronized void increment() {
        value++;
    }
}