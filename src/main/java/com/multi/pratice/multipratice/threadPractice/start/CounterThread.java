package com.multi.pratice.multipratice.threadPractice.start;

import com.multi.pratice.multipratice.threadPractice.util.MyLogger;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.*;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.start
 * fileName : CounterThread
 * author : taeil
 * date : 2024. 8. 31.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 8. 31.        taeil                   최초생성
 */
public class CounterThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            log("value : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}