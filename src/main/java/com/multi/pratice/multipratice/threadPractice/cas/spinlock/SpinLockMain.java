package com.multi.pratice.multipratice.threadPractice.cas.spinlock;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.log;
import static com.multi.pratice.multipratice.threadPractice.util.ThreadUtils.sleep;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.cas.spinlock
 * fileName : SpinLockMain
 * author : taeil
 * date : 2024. 9. 8.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 8.        taeil                   최초생성
 */
public class SpinLockMain {

    public static void main(String[] args) {
        //SpinLockBad spinLock = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                spinLock.lock();
                try {
                    // 임계 영역
                    log("비즈니스 로직 실행");
                    // 로직이 오래 걸리면 스핀 락은 사용해서는 안된다.
                    sleep(1);
                } finally {
                    spinLock.unlock();
                }
            }
        };

        Thread t1 = new Thread(runnable, "Thread-1");
        Thread t2 = new Thread(runnable, "Thread-2");

        t1.start();
        t2.start();

    }
}