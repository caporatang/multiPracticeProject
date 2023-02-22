package com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface.shelf;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface.shelf
 * fileName : BookShelf
 * author : taeil
 * date : 2023/02/08
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/08        taeil                   최초생성
 */
public class BookShelf extends Shelf implements Queue {

    @Override
    public void enQueue(String title) {
        shelf.add(title);
    }

    @Override
    public String deQueue() {
        return shelf.remove(0);
    }

    @Override
    public int getSize() {
        return getCount();
    }
}