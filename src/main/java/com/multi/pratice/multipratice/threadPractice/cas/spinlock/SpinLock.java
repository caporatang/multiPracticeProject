package com.multi.pratice.multipratice.threadPractice.cas.spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

import static com.multi.pratice.multipratice.threadPractice.util.MyLogger.log;
import static com.multi.pratice.multipratice.threadPractice.util.ThreadUtils.sleep;

/**
 * packageName : com.multi.pratice.multipratice.threadPractice.cas.spinlock
 * fileName : SpinLockBad
 * author : taeil
 * date : 2024. 9. 8.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 9. 8.        taeil                   최초생성
 */
public class SpinLock {

    private final AtomicBoolean lock = new AtomicBoolean(false);

    public void lock() {
        log("락 획득 시도");
        while (!lock.compareAndSet(false, true)) {
            log("락 획득 실패 - 스핀 대기");

        }
        log("락 획득 완료");
    }

    public void unlock() {
        lock.set(false);
        log("락 반납 완료");
    }

}