package com.multi.pratice.multipratice.java.basic.oop.statickeyword.singletonpattern;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.statickeyword.singletonpattern
 * fileName : CarFactoryTest
 * author : taeil
 * date : 2023/01/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/18        taeil                   최초생성
 */
public class CarFactoryTest {

    public static void main(String[] args) {
        CarFactory factory = CarFactory.getInstance();
        Car sonata1 = CarFactory.createCar();
        Car sonata2 = CarFactory.createCar();


        System.out.println(sonata1.getCarNum());
        System.out.println(sonata2.getCarNum());
    }


}