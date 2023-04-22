package com.multi.pratice.multipratice.java.basic.oop.thread.join;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.thread.join
 * fileName : ThreadJoin
 * author : taeil
 * date : 2023/04/22
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/22        taeil                   최초생성
 */
public class ThreadJoin {
    // 동시에 두 개 이상의 Thread가 실행 될 때 다른 Thread의 결과를 참조 하여 실행해야 하는 경우 join() 함수 사용
    // join() 함수를 호출한 Thread가 Not-runnable 상태로 감
    // 다른 Thread의 수행이 끝나면 runnable 상태로 돌아간다.

    // interupt() 메서드
    // 다른 Thread에 예외를 발생시키는 interrupt를 보낸다.
    // Thread가 join(), sleep(), wait() 함수에 의해 not-runnable 상태일 때 interrupt() 메서드를 호출하면 다시 runnable 상태로 돌아간다.

}