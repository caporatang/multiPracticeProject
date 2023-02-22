package com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface.shelf;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface.shelf
 * fileName : BookShelfTest
 * author : taeil
 * date : 2023/02/08
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/08        taeil                   최초생성
 */
public class BookShelfTest {
    public static void main(String[] args) {
        Queue bookQueue = new BookShelf();
        bookQueue.enQueue("해리포터1");
        bookQueue.enQueue("해리포터2");
        bookQueue.enQueue("해리포터3");
        bookQueue.enQueue("해리포터4");

        System.out.println(bookQueue.getSize());
        System.out.println(bookQueue.deQueue());
        System.out.println(bookQueue.deQueue());
        System.out.println(bookQueue.deQueue());
        System.out.println(bookQueue.deQueue());
        System.out.println(bookQueue.getSize());
    }

}