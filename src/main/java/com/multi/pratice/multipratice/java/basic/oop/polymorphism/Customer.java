package com.multi.pratice.multipratice.java.basic.oop.polymorphism;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.extendss
 * fileName : Customer
 * author : taeil
 * date : 2023/01/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/18        taeil                   최초생성
 */
public class Customer {
    // protected --> 상위 클래스에 선언된 private 맴버 변수는 하위 클래스에서 접근 할 수 없음
    // 외부 클래스는 접근 할 수 없지만, 하위 클래스는 접근 할 수 있도록 protected 접근 제어자를 사용해야함
    protected int customerId;
    protected String customerName;

    protected String customerGrade;
    int bonusPoint;
    double bonusRatio;

//    public Customer()
//    {
//        customerGrade = "SILVER";
//        bonusRatio = 0.01;
//        System.out.println("Customer() call");
//    }

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        customerGrade = "SILVER";
        bonusRatio = 0.01;

    }

    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        return price;
    }

    public String showCustomerInfo() {
        return customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다";
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }



}