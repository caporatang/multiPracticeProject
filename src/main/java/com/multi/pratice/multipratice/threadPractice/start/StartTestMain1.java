package com.multi.pratice.multipratice.threadPractice.start;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.start
 * fileName : StartTestMain1
 * author : taeil
 * date : 2024. 8. 31.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 8. 31.        taeil                   최초생성
 */
public class StartTestMain1 {
    public static void main(String[] args) {
        CounterThread counterThread = new CounterThread();
        counterThread.start();
    }
}