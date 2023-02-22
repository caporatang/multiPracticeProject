package com.multi.pratice.multipratice.java.basic.oop.abstractclass.methodPattern;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.abstractclass.methodPattern
 * fileName : ManualCar
 * author : taeil
 * date : 2023/02/01
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/01        taeil                   최초생성
 */
public class ManualCar extends Car{
    @Override
    public void drive() {
        System.out.println("사람이 운전을함");
        System.out.println("사람이 핸들을 조작함");
    }

    @Override
    public void stop() {
        System.out.println("장애물 앞에서 브레이크를 밟아서 정지함");
    }

    @Override
    public void wiper() {

    }
}