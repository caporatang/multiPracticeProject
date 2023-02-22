package com.multi.pratice.multipratice.java.basic.oop.extendss.Overridee;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.extendss
 * fileName : CustomerTest
 * author : taeil
 * date : 2023/01/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/18        taeil                   최초생성
 */
public class CustomerTest {

    public static void main(String[] args) {
        Customer customerLee = new Customer(10010, "lee~");
        customerLee.bonusPoint = 1000;
        int price = customerLee.calcPrice(1000);
        System.out.println(customerLee.showCustomerInfo() + price);


        VIPCustomer customerKim = new VIPCustomer(10020, "kim~");
        customerKim.bonusPoint = 10000;
        price = customerKim.calcPrice(1000);
        System.out.println(customerKim.showCustomerInfo() + price);


        // 이런 경우에, Customer타입으로 받는다고 하더라도 인스턴스(new)에서 오버라이드한 메서드가 호출된다.
        // 이런 방식은 가상함수 방식이라고하고 , 자바에서는 가상메서드라고 함, 자바의 모든 메서드는 가상메서드다
        Customer vc = new VIPCustomer(12345, "noname");
        System.out.println(vc.calcPrice(1000));

    }
}