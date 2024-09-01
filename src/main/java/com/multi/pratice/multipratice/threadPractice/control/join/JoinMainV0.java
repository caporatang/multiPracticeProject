package com.multi.pratice.multipratice.threadPractice.control.join;

import com.multi.pratice.multipratice.threadPractice.util.MyLogger;
import com.multi.pratice.multipratice.threadPractice.util.ThreadUtils;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.*;
import static com.multi.pratice.multipratice.threadPractice.util.ThreadUtils.*;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.control.join
 * fileName : JoinMainV0
 * author : taeil
 * date : 2024. 9. 1.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 1.        taeil                   최초생성
 */
public class JoinMainV0 {
    public static void main(String[] args) {
        log("Start");
        Thread thread1 = new Thread(new Job(), "thread-1");
        Thread thread2 = new Thread(new Job(), "thread-2");

        thread1.start();
        thread2.start();
        log("End");
    }

    static class Job implements Runnable {
        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);

            log("작업 완료");
        }
    }

}