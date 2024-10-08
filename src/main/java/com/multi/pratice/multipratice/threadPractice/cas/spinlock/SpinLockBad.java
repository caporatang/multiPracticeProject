package com.multi.pratice.multipratice.threadPractice.cas.spinlock;

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
public class SpinLockBad {

    private volatile boolean lock = false;

    public void lock() {
        log("락 획득 시도");
        while (true) {
            if (!lock) { // 락 사용 여부 확인
                sleep(100); // 문제 상황 확인, 스레드 대기
                lock = true; // 어떤 스레드가 락을 획득한 경우 true
                break;
            }  else {
                // 락을 획득할 때 까지 스핀 대기
                log("락 획득 실패 - 스핀 대기");
            }
        }
        log("락 획득 완료");
    }

    public void unlock() {
        lock = false;
        log("락 반납 완료");
    }

}