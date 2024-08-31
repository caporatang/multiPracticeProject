package com.multi.pratice.multipratice.threadPractice.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.util
 * fileName : MyLogger
 * author : taeil
 * date : 2024. 8. 31.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 8. 31.        taeil                   최초생성
 */
public abstract class MyLogger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object obj) {
        String time = LocalDateTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), obj);
    }
}