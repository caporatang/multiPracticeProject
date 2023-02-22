package com.multi.pratice.multipratice.springbasic.designpattern.decorator;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.decorator
 * fileName : Audi
 * author : taeil
 * date : 2023/02/19
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/19        taeil                   최초생성
 */
public class Audi implements ICar {
    private int price;

    public Audi(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void showPrice() {
        System.out.println("audi의 가격은 " + this.price + "원 입니다 ");
    }
}
