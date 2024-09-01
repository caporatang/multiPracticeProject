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
public class ThreadStopMainV3 {
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
            while (!Thread.currentThread().isInterrupted()) {// 인터럽트 상태 변경은 x
                log("작업 중");
            }

            /*
            * 이렇게 인터럽트 상태를 체크하는 코드의 문제점은 스레드 인터럽트 상태가 계속 true로 유지된다는 점이다.
            * 현재 시점에 true인데 아래에 자원 정리 부분에 sleep 에서 계속해서 인터럽트 상태이기 때문에, 익셉션이 발생하게 된다.
            * try-catch에서 인터럽트를 체크하게 되면 자바에서 자동으로 스레드의 인터럽트 상태를 false로 바꿔주는 이유가 이런 이유이다.
            * 인터럽트를 사용해서 의도적으로 특정 로직의 기능을 수행했다면 다시 인터럽트 상태를 다시 정상으로 돌려야한다.
            * */
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

            try {
                log("자원 정리 시도");
                Thread.sleep(1000);
                log("자원 정리 완료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                // 여기서는 false로 변경된다. -> 자바에서 바꿔줌
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
            }
            log("작업 종료");
        }
    }
}