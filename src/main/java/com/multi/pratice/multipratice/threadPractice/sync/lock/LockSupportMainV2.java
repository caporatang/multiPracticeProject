package com.multi.pratice.multipratice.threadPractice.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.log;
import static com.multi.pratice.multipratice.threadPractice.util.ThreadUtils.sleep;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.sync.lock
 * fileName : LockSupportMainV1
 * author : taeil
 * date : 2024. 9. 6.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 6.        taeil                   최초생성
 */
public class LockSupportMainV2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new ParkTest(), "Thread-1");
        thread.start();

        sleep(100);
        log("Thread-1 state : " + thread.getState());
    }

    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");

            // 2초 뒤에 깨어남
            LockSupport.parkNanos(2000_000000);

            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태 : " + Thread.currentThread().isInterrupted());
        }
    }
}