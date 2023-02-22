package com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface
 * fileName : CustomerTest
 * author : taeil
 * date : 2023/02/08
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/08        taeil                   최초생성
 */
public class CustomerTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.sell();
        customer.buy();
        customer.hello();
        customer.order();

        Buy buyer = customer;
        buyer.buy();
        buyer.order();

        Sell seller = customer;
        seller.sell();
        seller.order();


    }
}