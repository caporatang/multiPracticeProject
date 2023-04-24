package com.multi.pratice.multipratice.java.basic.oop.thread.waitnotify;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.thread.waitnotify
 * fileName : WaitNotify
 * author : taeil
 * date : 2023/04/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/24        taeil                   최초생성
 */
public class WaitNotify {
    // 리소스가 어떤 조건에서 더 이상 유효하지 않은 경우 리소스를 기다리기 위해 Thread가 wait() 상태가 된다.
    // wait() 상태가 된 Thread는 notify() 가 호출 될 때까지 기다림.
    // 유효한 자원이 생기면 notify()가 호출되고 wait() 하고 있는 THread 중 무작위로 하나의 Thread를 재시작 하도록 한다.
    // notifyAll()이 호출되는 경우 wait() 하고 있는 모든 Thread가 재시작.
    // 이 경우 유효한 리소스만큼의 Thread만이 수행될 수 있고 자원을 갖지 못한 Thread의 경우는 다시 wait() 상태로 만든다.
    // 자바에서는 notifyAll() 메서드의 사용을 권장.
}