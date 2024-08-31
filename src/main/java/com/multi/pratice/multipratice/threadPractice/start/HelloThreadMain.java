package com.multi.pratice.multipratice.threadPractice.start;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.start
 * fileName : HelloThreadMain
 * author : taeil
 * date : 8/30/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 8/30/24        taeil                   최초생성
 */
public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " : start() 호출 전");

        // 스택 영역에 공간을 할당받아서 실제로 실행되는 시점은 start 메서드를 호출한 후
        helloThread.start();

        System.out.println(Thread.currentThread().getName() + " : start() 호출 후");

        System.out.println(Thread.currentThread().getName() + " : main() end");
    }
}