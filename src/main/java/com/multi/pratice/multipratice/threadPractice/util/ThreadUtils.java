package com.multi.pratice.multipratice.threadPractice.util;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.*;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.util
 * fileName : ThreadUtils
 * author : taeil
 * date : 2024. 9. 1.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 1.        taeil                   최초생성
 */
public abstract class ThreadUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log("인터럽트 : " + e.getMessage());
            throw new RuntimeException(e);
        }

    }
}