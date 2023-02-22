package com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface.shelf;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface
 * fileName : Queue
 * author : taeil
 * date : 2023/02/08
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/08        taeil                   최초생성
 */
public interface Queue {

    void enQueue(String title);

    String deQueue();

    int getSize();

}