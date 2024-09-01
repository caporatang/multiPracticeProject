package com.multi.pratice.multipratice.threadPractice.control.yield;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.control.yieldMain
 * fileName : YieldMain
 * author : taeil
 * date : 2024. 9. 2.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 2.        taeil                   최초생성
 */
public class YieldMain {

    static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0; i <THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i <10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }


            // 테스트 케이스
            // 1. empty

            /*
             sleep()
             상태는 Runnable로 유지된다. CPU에서 실행 해야되는데 양보하고 다시 대기큐로 돌아간다.
             결과적으로 TIMED_WAITING 상태가 되면서 다른 스레드에 실행을 양보하고 대기큐로 간다는것이다.
             하지만, 이러한 방식은 RUNNABLE -> TIMED_WAITING -> RUNNABLE로 변경되는 과정이 필요하고 또 특정 시간만큼 스레드가 실행되지 않는 단점이 있다.
             예를 들어, 양보할 스레드가 없으면 차라리 나의 스레드를 더 실행하는 방법이 더 나을 수 있다. -> 양보할 사람이 없는데 자리를 양보한다? 말이 안된다.
            */
            // 2. sleep(1)
            // sleep(1);

            /*
             sleep의 단점을 보완하기 위한 yield
             자바의 스레드가 Runnable 상태일 때, 운영체제의 스케줄링은 다음과 같은 상태들을 가질 수 있다.
                - 실행 상태 (Running) : 스레드가 CPU에서 실제로 실행 중이다.
                - 실행 대기 상태 (Ready) : 스레드가 실행될 준비가 되었지만, CPU가 바빠 스케줄링 큐에서 대기 중
            운영체제는 실행 상태의 스레드들을 잠깐만 실행하고 실행 대기 상태로 만든다. 그리고 실행 대기 상태의 스레드들을 잠깐만 실행 상태로 변경해서 실행한다.
            */
            // 3.Thread.yield();
            Thread.yield();
        }
    }


}