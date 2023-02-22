package com.multi.pratice.multipratice.java.basic.oop.extendss;

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
//        Customer customerLee = new Customer();
//        customerLee.setCustomerName("lee~");
//        customerLee.setCustomerId(10010);
//        customerLee.bonusPoint = 1000;
//
//        System.out.println(customerLee.showCustomerInfo());


        VIPCustomer customerKim = new VIPCustomer();
        customerKim.setCustomerName("kim~");
        customerKim.setCustomerId(10020);
        customerKim.bonusPoint = 10000;
        System.out.println(customerKim.showCustomerInfo());



    }
}