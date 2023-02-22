package com.multi.pratice.multipratice.java.basic.oop.abstractclass;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.abstractclass
 * fileName : DeskTop
 * author : taeil
 * date : 2023/02/01
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/01        taeil                   최초생성
 */
public class DeskTop extends Computer{

    @Override
    public void display() {
        System.out.println("Desktop display");
    }

    @Override
    public void typing() {
        System.out.println("Desktop display");
    }

    @Override
    public void turnOff() {
        System.out.println("Desktop turnOff");
    }
}