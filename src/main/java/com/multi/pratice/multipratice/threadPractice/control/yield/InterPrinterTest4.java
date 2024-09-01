package com.multi.pratice.multipratice.threadPractice.control.yield;


import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.log;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.control.printer
 * fileName : InterPrinterTest
 * author : taeil
 * date : 2024. 9. 2.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 2.        taeil                   최초생성
 */
public class InterPrinterTest4 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while (true) {
            log("프린트 문서 입력. 종료 (q) : " );
            String input = userInput.nextLine();
            if (input.equals("q")) {
                printerThread.interrupt();
                break;
            }
            printer.addJob(input);
        }
    }

    static class Printer implements Runnable {
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (jobQueue.isEmpty()) {
                    // 큐가 비어있다? 그럼 다른 스레드에게 양보 실행을 양보
                    Thread.yield(); // 추가
                    continue;
                }

                try {
                    String job = jobQueue.poll();
                    log("출력 시작 : " + job +  ", 대기 문서 : " + jobQueue);
                    Thread.sleep(3000);
                    log("출력 완료");
                } catch (InterruptedException e) {
                    log("인터럽트 ! ");
                    break;
                }
            }
            log("프린터 종료");
        }

        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }

}