package com.multi.pratice.multipratice.springbasic.synchronizedTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.synchronizedTest
 * fileName : UseSynchronized
 * author : taeil
 * date : 6/13/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 6/13/24        taeil                   최초생성
 */
public class UseSynchronized {
    private int count;
    private static int countStatic;

    public synchronized int add(int value) {
        this.count += value;
        return count;
    }

    public static synchronized int addStatic(int value) {
        countStatic += value;
        return  countStatic;
    }

    public int addBlock(int value) {
        synchronized (this) {
            this.count += value;
        }
        return count;
    }
}