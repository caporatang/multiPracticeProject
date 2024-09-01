package com.multi.pratice.multipratice.threadPractice.control.interrupted;

import com.multi.pratice.multipratice.threadPractice.util.MyLogger;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.*;
import static com.multi.pratice.multipratice.threadPractice.util.ThreadUtils.sleep;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.control.interrupted
 * fileName : ThreadStopMainV1
 * author : taeil
 * date : 2024. 9. 2.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 2.        taeil                   최초생성
 */
public class ThreadStopMainV1 {
    public static void main(String[] args) {
        // 이런 방식은 바로 중단 시키는게 아니니까 문제가 된다.
        StopTask stopTask = new StopTask();
        Thread thread = new Thread(stopTask, "work");
        thread.start();

        sleep(4000);
        log("작업 중단 지시 runFlag=false");
        stopTask.runFlag = false;
    }

    static class StopTask implements Runnable {
        volatile boolean runFlag = true;

        @Override
        public void run() {
            while (runFlag) {
                log("작업 중");
                sleep(3000);
            }
            log("자원 정리");
            log("자원 종료");
        }
    }
}