package com.multi.pratice.multipratice.threadPractice.start;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.start
 * fileName : HelloRunnable
 * author : taeil
 * date : 2024. 8. 31.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 8. 31.        taeil                   최초생성
 */
public class HelloRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": run()");
    }
}