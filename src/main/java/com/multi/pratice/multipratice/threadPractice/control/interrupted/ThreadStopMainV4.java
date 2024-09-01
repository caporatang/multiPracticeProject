package com.multi.pratice.multipratice.threadPractice.control.interrupted;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.log;
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
public class ThreadStopMainV4 {
    public static void main(String[] args) {

        StopTask stopTask = new StopTask();
        Thread thread = new Thread(stopTask, "work");
        thread.start();

        sleep(100);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());

    }

    static class StopTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) { // 체크와 동시에 스레드의 상태를 변경
                /*
                 isInterrupted
                 스레드가 인터럽트 상태라면 true 반환, 해당 스레드의 인터럽트 상태를 false로 변경
                 스레드가 인터럽트 상태가 아니라면 false를 반환하고, 해당 스레드의 인터럽트 상태를 변경하지 않는다.
                * */
                log("작업 중");
            }

            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

            try {
                log("자원 정리 시도");
                Thread.sleep(1000);
                log("자원 정리 완료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
            }
            log("작업 종료");
        }
    }
}