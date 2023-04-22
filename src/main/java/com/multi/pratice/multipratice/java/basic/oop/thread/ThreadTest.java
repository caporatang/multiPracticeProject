package com.multi.pratice.multipratice.java.basic.oop.thread;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.thread
 * fileName : MyThread
 * author : taeil
 * date : 2023/04/22
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/22        taeil                   최초생성
 */

/*
class MyThread extends Thread {
    // 상속받아서 처리하는 경우
    public void run() {
        int i;
        for(i = 1; i<=200; i++) {
            System.out.print(i + "\t");
        }
    }
}
*/

class MyThread implements Runnable {
    // 이미 다른 클래스를 상속받은 경우
    @Override
    public void run() {
        int i;
        for(i = 1; i<=200; i++) {
            System.out.print(i + "\t");
        }
    }
}

public class ThreadTest {

    public static void main(String[] args) {
        // Thread를 상속받은 경우.
        // 아래의 예제를 실행 시키면 실행되는 스레드는 3개
        // main, th1, th2
        // System.out.println(Thread.currentThread() + "start");
        // MyThread th1 = new MyThread();
        // MyThread th2 = new MyThread();

        // th1.start();
        // th2.start();
        // System.out.println(Thread.currentThread() + "end");

        // currentThread -> 현재 실행되는 thread의 정보를 가지고 오는 스태틱 메서드
        // [호출한 함수, 우선순위, thread그룹(어디에 속해있는지)]
        // Thread[main,5,main]start
        // Thread[main,5,main]end


        // 인터페이스 implements를 사용하는 경우
        System.out.println(Thread.currentThread() + "start");

        MyThread runnable = new MyThread();

        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);

        th1.start();
        th2.start();

        System.out.println(Thread.currentThread() + "end");

        // 익명 객체로 구현
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };
        run.run();
    }
}