package com.multi.pratice.multipratice.threadPractice.control;

import com.multi.pratice.multipratice.threadPractice.start.HelloRunnable;
import com.multi.pratice.multipratice.threadPractice.util.MyLogger;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.*;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.control
 * fileName : ThreadInfoMain
 * author : taeil
 * date : 2024. 8. 31.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 8. 31.        taeil                   최초생성
 */
public class ThreadInfoMain {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.threadId() = " + mainThread.threadId());
        log("mainThread.getName() = " + mainThread.getName());
        log("mainThread.getPriority() = " + mainThread.getPriority()); // 우선 순위
        log("mainThread.getThreadGroup() = " + mainThread.getThreadGroup()); // 스레드 그룹
        log("mainThread.getState() = " + mainThread.getState()); // 상태

        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("myThread = " + myThread);
        log("myThread.threadId() = " + myThread.threadId());
        log("myThread.getName() = " + myThread.getName());
        log("myThread.getPriority() = " + myThread.getPriority()); // 우선 순위
        log("myThread.getThreadGroup() = " + myThread.getThreadGroup()); // 스레드 그룹
        log("myThread.getState() = " + myThread.getState()); // 상태
    }
}