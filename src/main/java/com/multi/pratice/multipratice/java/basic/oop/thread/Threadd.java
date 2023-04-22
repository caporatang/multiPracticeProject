package com.multi.pratice.multipratice.java.basic.oop.thread;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.thread
 * fileName : Threadd
 * author : taeil
 * date : 2023/04/22
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/22        taeil                   최초생성
 */
public class Threadd {
    // Thread란?
    // process 실행 중인 프로그램. 프로그램이 실행되면 OS로 부터 메모리를 할당받아 프로세스 상태가 된다.
    // thread 하나의 프로세스는 하나 이상의 thread를 가지게 되고, 실제 작업을 수행하는 단위가 thread.
    // Process ( (thread), (thread))

    // multi-threading
    // 여러 thread가 동시에 수행되는 프로그래밍. 여러 작업이 동시에 실행되는 효과
    // thread는 각각 자신만의 작업 공간을 가진다 (context)
    // 각 thread 사이에서 공유하는 자원이 있을 수 있다. --> ex) 자바에서는 static, instance
    // 여러 thread가 자원을 공유하여 작업이 수행되는 경우 서로 자원을 차지하려는 race condition이 발생할 수 있다.
    // 여러 thread가 공유하는 자원중 경쟁이 발생하는 부분을 critical section 이라고 한다.
    // critical section에 대한 동기화(일종의 순차적 수행)을 구현하지 않으면 오류가 발생할 수 있다.

    // 스레드의 상태 Thread Status
    // 스레드가 시작되면 thread pool에 들어오게 된다.
    // thread pool에 있는 thread들은 Runnable한 상태로 cpu 배분을 대기한다.
    // thread가 종료되면 Dead 상태라고 한다.

    // Not Runnable 상태.
    // CPU를 절대 점유할수 없는 상태를 뜻한다.
    // thread.sleep(), wait(), join() 메서드를 사용 했을 때, Not Runnable 상태 라고 한다.
    // sleep(ms) -> 밀리 세컨드를 매개변수로 사용함 -> 지정된 시간만큼 대기하다가 지정된 시간이 끝나면 다시 Runnable 상태로 돌아감
    // wait() -> 소스는 한정되어 있는데, 스레드가 여러개인 경우에 유효한 스레드가 생길때까지 대기한다.
    //           유효한 스레드가 생기면 notify()는 무작위 하나, notifyAll()은 wait이 걸려있는 전체를 실행하여 Runnable 상태로 만든다
    // join() -> 두개의 스레드가 실행되고 있을 때, 하나의 스레드의 결과를 참조 해야할 때 join()을 걸어주면, 다른 스레드가 종료되어 결과가 나올때까지 Not Runnable 상태로 대기한다. -> other thread exits

}