package com.multi.pratice.multipratice.java.basic.oop.statickeyword.singletonpattern;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.statickeyword.singletonpattern
 * fileName : CarFactory
 * author : taeil
 * date : 2023/01/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/18        taeil                   최초생성
 */
public class CarFactory {
    // 복습용 클래스

    private static int carNum = 10000;

    //외부에서 접근할수 없게 기본 생성자없이 private로 설정
    private CarFactory() { }
    // 유일 객체를 만들자
    private static CarFactory instance = new CarFactory();

    public static CarFactory getInstance() {
        //외부에서 접근할수있게 --> 객체를 가져다 쓸수있게 만들어주자
        if(instance == null) {
            instance = new CarFactory();
        }
        return instance;
    }

    public static Car createCar() {
        Car car = new Car();
        car.setCarNum(carNum++);
        return car;
    }


}