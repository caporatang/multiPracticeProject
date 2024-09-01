package com.multi.pratice.multipratice.threadPractice.volatile1;

import com.multi.pratice.multipratice.threadPractice.util.ThreadUtils;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.log;
import static com.multi.pratice.multipratice.threadPractice.util.ThreadUtils.*;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.volatile1
 * fileName : VolatileCountMain
 * author : taeil
 * date : 2024. 9. 2.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 2.        taeil                   최초생성
 */
public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(1000);

        task.flag = false;
        log("flag = "  + task.flag + ", count " + task.count +" 종료");
    }

    static class MyTask implements Runnable {
        //boolean flag = true;
        //long count;

        volatile boolean flag = true;
        volatile long count;


        @Override
        public void run() {
            while (flag) {
                count++;
                // 1억번에 한번씩 출력
                if (count % 100_100_100 == 0) {
                    log("flag = "  + flag + ", count " + count +" in while()");
                }
            }
            log("flag = "  + flag + ", count " + count +" 종료");
        }
    }
}