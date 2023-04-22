package com.multi.pratice.multipratice.java.basic.oop.thread;

import java.io.IOException;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.thread
 * fileName : TerminateThread
 * author : taeil
 * date : 2023/04/22
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/22        taeil                   최초생성
 */
public class TerminateThread extends Thread{
    // Thread를 종료할 때 사용
    // 예전엔 stop() 메서드를 사용해서 thread를 종료
    // 무한 반복의 경우 while(flag)의 flag 변수값을 false로 바꾸어 종료 시킨다.

    // 세 개의 thread
    // 각각 무한루프 수행
    // 'A'를 입력 받으면 첫 번째 thread
    // 'B'를 입력 받으면 두 번째 thread
    // 'C'를 입력 받으면 세 번째 thread
    // 'M'을 입력 받으면 모든 thread와 main() 함수를 종료

    private boolean flag = false;
    int i;

    public TerminateThread(String name) {
        super(name);
    }

    public void run() {
        while (!flag) {
            try {
                sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println( getName() + "end");
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) throws IOException {
        TerminateThread threadA = new TerminateThread("A"); // thread 안에 스트링을 매개변수로 주면 스레드의 이름이다.
        TerminateThread threadB = new TerminateThread("B");
        TerminateThread threadC = new TerminateThread("C");

        threadA.start();
        threadB.start();
        threadC.start();

        int in;
        while (true) {
            in = System.in.read();

            if( in == 'A') {
                threadA.setFlag(true);
            } else if(in == 'B') {
                threadB.setFlag(true);
            } else if(in == 'C') {
                threadC.setFlag(true);
            } else if( in == 'M') {
                threadA.setFlag(true);
                threadB.setFlag(true);
                threadC.setFlag(true);
                break;
            }
        }
        System.out.println("main end");

    }
}


