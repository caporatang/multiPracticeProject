package com.multi.pratice.multipratice.java.basic.oop.abstractclass;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.abstractclass
 * fileName : Computer
 * author : taeil
 * date : 2023/02/01
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/01        taeil                   최초생성
 */
public abstract class Computer {

    public abstract void display();
    public abstract void typing();

    public void turnOn() {
        System.out.println("전원을 키자");
    }
    public void turnOff() {
        System.out.println("전원을 끄자");
    }


}