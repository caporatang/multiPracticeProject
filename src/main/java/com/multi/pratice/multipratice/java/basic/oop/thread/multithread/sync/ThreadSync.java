package com.multi.pratice.multipratice.java.basic.oop.thread.multithread.sync;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.thread.multithread
 * fileName : MultiThread
 * author : taeil
 * date : 2023/04/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/23        taeil                   최초생성
 */
public class ThreadSync {
    // 멀티 Thread 프로그래밍에서의 동기화 처리

    // critical section 과 semaphore
    // critical section 은 두 개 이상의 thread가 동시에 접근 하는 경우 문제가 생길 수 있기 떄문에 동시에 접근할 수 없는 영역
    // semaphore 는 특별한 형태의 시스템 객체이면 get/release 두 개의 기능이 있다.
    // 한 순간 오직 하나의 thread 만이 semaphore를 얻을 수 있고, 나머지 thread들은 대기(blocking) 상태가 된다.

    // semaphore를 얻은 thread 만이 critical section에 들어갈 수 있다.
    // thread1 이 release가 되어야 thread2 를 get()을 통해 호출 -> semaphore를 얻고 리소스를 처리 하고 -> 다시 release 하면 thread3 으로.
    // 한번에 접근하는 것이 아닌, 순차적으로 처리 된다 -> semaphore 는 일종의 열쇠다.
    // thread1    get() - semaphore - release()
    // thread2    get() - semaphore - release()
    // thread3    get() - semaphore - release()

    // 동기화 (synchronization)
    // 두 개의 thread 가 같은 객체에 접근 할 경우, 동시에 접근 함으로써 오류가 발생된다.
    // 동기화는 임계영역에 접근한 경우 공유자원을 lock 하여 다른 thread의 접근을 제어함
    // 동기화를 잘못 구현하면 deadlock에 빠질 수 있다.

    // 자바에서는 synchronized 메서드나 synchronized 블럭을 사용함
    // 1. synchronized 블럭 -> 현재 객체 또는 다른 객체를 lock으로 만든다.
    // synchronized (참조형 수식) {
    //      수행문;
    // }
    // 2. synchronized 메서드
    // 객체의 메서드에 synchronized 키워드 사용
    // 현재 이 메서드가 속해있는 객체에 lock
    // 자바에서는 deadlock을 방지하는 기술이 제공되지 않는다. -> synchronized 메서드에서 다른 synchronized 메서드는 호출하면 안된다.

    // deadLock이란 ? -> 교착 상태
    // 두개의 스레드가 있을 때, 두개의 스레드가 서로의 처리가 끝나길 기다리는 무한정 대기상태

}