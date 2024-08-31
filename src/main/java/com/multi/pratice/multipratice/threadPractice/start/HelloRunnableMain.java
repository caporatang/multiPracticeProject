package com.multi.pratice.multipratice.threadPractice.start;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.start
 * fileName : HelloRunnableMain
 * author : taeil
 * date : 2024. 8. 31.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 8. 31.        taeil                   최초생성
 */
public class HelloRunnableMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        // 별도의 스레드에서 실행
        HelloRunnable helloRunnable = new HelloRunnable();
        Thread thread = new Thread(helloRunnable);
        thread.start();

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }


}