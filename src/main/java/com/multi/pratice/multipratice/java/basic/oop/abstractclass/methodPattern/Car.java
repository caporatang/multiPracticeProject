package com.multi.pratice.multipratice.java.basic.oop.abstractclass.methodPattern;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.abstractclass.methodPattern
 * fileName : Car
 * author : taeil
 * date : 2023/02/01
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/01        taeil                   최초생성
 */
public abstract class Car {
    public abstract void drive();
    public abstract void stop();
    public abstract void wiper();


    public void startCar() {
        System.out.println("시동을 켭니다");
    }

    public void turnOff() {
        System.out.println("시동을 끕니다");
    }

    // 구현부가 존재하기 때문에 추상메서드가 아님, 하위클래스에서 재정의해서 사용
    public void washCar() {}

    final public void run() {
        // 시나리오 자체는 변하면 안된다. --> 하위 클래스에서도 반드시 이 순서대로 진행해야한다
        startCar();
        drive();
        wiper();
        stop();
        turnOff();
        washCar();

    }
}