package com.multi.pratice.multipratice.threadPractice.start;

import com.multi.pratice.multipratice.threadPractice.util.MyLogger;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.*;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.start
 * fileName : InnerRunnableMainV1
 * author : taeil
 * date : 2024. 8. 31.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 8. 31.        taeil                   최초생성
 */
public class InnerRunnableMainV1 {
    public static void main(String[] args) {
        log("main() start");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        log("main() end");
    }
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log("run()");
        }
    }
}