package com.multi.pratice.multipratice.java.basic.oop.extendss.extendscast;

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
//        customerLee.setCustomerName("lee~");
//        customerLee.setCustomerId(10010);
        customerLee.bonusPoint = 1000;

        System.out.println(customerLee.showCustomerInfo());


        VIPCustomer customerKim = new VIPCustomer(10020, "kim~");
//        customerKim.setCustomerName("kim~");
//        customerKim.setCustomerId(10020);
        customerKim.bonusPoint = 10000;
        System.out.println(customerKim.showCustomerInfo());

        //customer 타입으로 업캐스팅한 경우에는 상위 클래스의 속성만 사용 가능하다.
        Customer vc = new VIPCustomer(12345, "noname");


    }
}