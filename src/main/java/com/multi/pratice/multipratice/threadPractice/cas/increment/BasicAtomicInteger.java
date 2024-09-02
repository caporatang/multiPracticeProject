package com.multi.pratice.multipratice.threadPractice.cas.increment;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.cas.increment
 * fileName : BasicAtomicInteger
 * author : taeil
 * date : 2024. 9. 2.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 2.        taeil                   최초생성
 */
public class BasicAtomicInteger implements IncrementInteger{

    AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public int get() {
        return atomicInteger.get();
    }

    @Override
    public void increment() {
        atomicInteger.incrementAndGet();
    }
}