package com.multi.pratice.multipratice.threadPractice.start;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.log;

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
public class InnerRunnableMainV2 {
    public static void main(String[] args) {
        log("main() start");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        log("main() end");
    }
}