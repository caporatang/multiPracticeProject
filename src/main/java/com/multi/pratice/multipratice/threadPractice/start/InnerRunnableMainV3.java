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
public class InnerRunnableMainV3 {
    public static void main(String[] args) {
        log("main() start");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        });

        thread.start();
        log("main() end");
    }
}