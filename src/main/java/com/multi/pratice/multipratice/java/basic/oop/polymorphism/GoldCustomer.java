package com.multi.pratice.multipratice.java.basic.oop.polymorphism;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.polymorphism
 * fileName : GoldCustomer
 * author : taeil
 * date : 2023/01/29
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/29        taeil                   최초생성
 */
public class GoldCustomer extends Customer{
    double salesRatio;

    public GoldCustomer(int customerId, String customerName) {
        super(customerId, customerName);
        salesRatio = 0.1;
        bonusRatio = 0.02;
        customerGrade = "GOLD";

    }

    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        return price - (int) (price * salesRatio);
    }

}