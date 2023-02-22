package com.multi.pratice.multipratice.java.basic.oop.abstractclass.methodPattern;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.abstractclass.methodPattern
 * fileName : CarTest
 * author : taeil
 * date : 2023/02/01
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/01        taeil                   최초생성
 */
public class CarTest {
    public static void main(String[] args) {
        System.out.println("-------------------나는 AI------------------------");
        Car aiCar = new AiCar();
        aiCar.run();
        System.out.println("-------------------나는 메뉴얼------------------------");
        Car mCar = new ManualCar();
        mCar.run();
    }

}