package com.multi.pratice.multipratice.threadPractice.start;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.*;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.start
 * fileName : ManyThreadMainV1
 * author : taeil
 * date : 2024. 8. 31.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 8. 31.        taeil                   최초생성
 */
public class ManyThreadMainV1 {
    public static void main(String[] args) {
        log("main() start");

        HelloRunnable runnable = new HelloRunnable();

        for (int i = 0; i <100; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
        log("main() end");
    }

}