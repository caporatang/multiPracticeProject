package com.multi.pratice.multipratice.java.basic.oop.exception.autocloseable;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.exception
 * fileName : AutCloseableObj
 * author : taeil
 * date : 2023/03/25
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/25        taeil                   최초생성
 */
public class AutoCloseableObj implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("closing..!");
    }
}