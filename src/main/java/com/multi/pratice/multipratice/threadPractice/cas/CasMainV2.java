package com.multi.pratice.multipratice.threadPractice.cas;

import java.util.concurrent.atomic.AtomicInteger;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.log;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.cas
 * fileName : CasMainV2
 * author : taeil
 * date : 2024. 9. 2.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 2.        taeil                   최초생성
 */
public class CasMainV2 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        // incrementAndGet 구현
        int resultValue1 = incrementAndGet(atomicInteger);
        System.out.println("resultValue1 = " + resultValue1);

        int resultValue2 = incrementAndGet(atomicInteger);
        System.out.println("resultValue1 = " + resultValue2);
    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;

        do {
            getValue = atomicInteger.get();
            log("getValue = " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
            log("result : " + result);
        } while (!result);

        return getValue + 1;
    }
}