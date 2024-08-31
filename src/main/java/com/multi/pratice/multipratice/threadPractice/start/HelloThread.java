package com.multi.pratice.multipratice.threadPractice.start;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.start
 * fileName : HelloThread
 * author : taeil
 * date : 8/30/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 8/30/24        taeil                   최초생성
 */
public class HelloThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run !");
    }
}