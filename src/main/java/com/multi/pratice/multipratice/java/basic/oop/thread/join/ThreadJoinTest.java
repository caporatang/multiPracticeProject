package com.multi.pratice.multipratice.java.basic.oop.thread.join;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.thread.join
 * fileName : ThreadJoinTest
 * author : taeil
 * date : 2023/04/22
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/22        taeil                   최초생성
 */
public class ThreadJoinTest extends Thread{
    int start;
    int end;
    int total;

    public ThreadJoinTest(int start, int end) {
        this.end = end;
        this.start = start;
    }

    public void run() {
        int i;
        for(i = start; i <= end; i++) {
            total += i;
        }
    }

    public static void  main(String[] args) {

        ThreadJoinTest jt1 = new ThreadJoinTest(1, 50); // 1 ~ 50까지 더하는건 1번 스레드
        ThreadJoinTest jt2 = new ThreadJoinTest(51, 100); // 51 ~ 100까지는 2번 스레드

        jt1.start();
        jt2.start();

        try {
            // 현재 main jt1 jt2 까지 스레드는 3개가 실행이 되는데, join을 걸지 않으면 jt1 jt2의 연산 결과가 나오지 않았는데 sout가 출력되어 의도하지 않은 값이 출력된다.
            // main에서 join을 걸게되면 main은 Not Runnable 상태로 빠지게 되는데, 일정 시간이 지났는데 스레드들이 결과가 나오지 않는다면 InterruptedException이 발생된다.
            jt1.join();
            jt2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }


        int lastTotal = jt1.total + jt2.total;
        System.out.println("jt1.total = " + jt1.total);
        System.out.println("jt2.total = " + jt2.total);
        System.out.println("lastTotal = " + lastTotal);

    }

}