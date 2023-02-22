package com.multi.pratice.multipratice.springbasic.designpattern.decorator;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.decorator
 * fileName : DecoratorTEst
 * author : taeil
 * date : 2023/02/19
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/19        taeil                   최초생성
 */
public class DecoratorTest {

    public static void main(String[] args) {
        // ICar로 기본 audi객체를 최초 생성함
        ICar audi = new Audi(1000);
        audi.showPrice();

        // 최송 생성한 Icar객체를 활용해서 3, 4, 5까지 만들어서 각각 다른 값이 출력
        // a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();
        // a4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();
        //a5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();
    }

}