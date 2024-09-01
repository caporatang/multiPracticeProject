package com.multi.pratice.multipratice.threadPractice.control.join;

import com.multi.pratice.multipratice.threadPractice.util.MyLogger;
import com.multi.pratice.multipratice.threadPractice.util.ThreadUtils;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.*;
import static com.multi.pratice.multipratice.threadPractice.util.ThreadUtils.*;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.control.join
 * fileName : JoinMainV1
 * author : taeil
 * date : 2024. 9. 2.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 2.        taeil                   최초생성
 */
public class JoinMainV1 {

    public static void main(String[] args) {
        log("Start");

        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        new Thread(task1, "thread-1").start();
        new Thread(task2, "thread-2").start();

        log("task1.result = " + task1.result);
        log("task2.result = " + task2.result);

        int sumAll = task1.result + task2.result;
        System.out.println("task1 + task2 = " + sumAll);

        log("End");
    }

    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료 result = " + result);
        }
    }

}