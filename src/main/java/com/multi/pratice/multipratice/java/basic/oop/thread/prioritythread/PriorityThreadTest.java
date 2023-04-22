package com.multi.pratice.multipratice.java.basic.oop.thread.prioritythread;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.thread.prioritythread
 * fileName : PriorityThreadTest
 * author : taeil
 * date : 2023/04/22
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/22        taeil                   최초생성
 */

class PriorityThread extends Thread {
    public void run() {
        int sum = 0;
        Thread t = Thread.currentThread();
        System.out.println(t + "start");

        for(int i = 0; i <= 10000; i++) {
            sum += i;
        }
        System.out.println( t.getPriority() + "end");
    }
}

public class PriorityThreadTest {

    public static void main(String[] args) {
        // 우선 순위와 끝나는 순서를 출력해보자
        // int i;

        // for(i= Thread.MIN_PRIORITY; i <= Thread.MAX_PRIORITY; i++) {
        //   PriorityThread pt = new PriorityThread();
        //   pt.setPriority(i);
        //   pt.start();
        // }

        PriorityThread pt1 = new PriorityThread();
        PriorityThread pt2 = new PriorityThread();
        PriorityThread pt3 = new PriorityThread();

        pt1.setPriority(Thread.MIN_PRIORITY);
        pt2.setPriority(Thread.NORM_PRIORITY);
        pt3.setPriority(Thread.MAX_PRIORITY);

        pt1.start();
        pt2.start();
        pt3.start();

    }
}