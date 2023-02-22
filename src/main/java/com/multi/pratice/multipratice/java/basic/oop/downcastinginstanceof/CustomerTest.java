package com.multi.pratice.multipratice.java.basic.oop.downcastinginstanceof;

import java.util.ArrayList;

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
        ArrayList<Customer> customerList = new ArrayList<>();

        Customer customerT = new Customer(10010, "normal capo");
        Customer customerJ = new Customer(10020, "normal xodlf");
        Customer customerE = new GoldCustomer(10030, "gold taeil");
        Customer customerP = new GoldCustomer(10040, "gold Tomas");
        Customer customerK = new VIPCustomer(10050, "VIP taeil~~");

        customerList.add(customerT);
        customerList.add(customerJ);
        customerList.add(customerE);
        customerList.add(customerP);
        customerList.add(customerK);

//        for(Customer customer : customerList) {
//            System.out.println(customer.showCustomerInfo());
//        }
//
//        int price = 10000;
//        for (Customer customer : customerList) {
//            int cost = customer.calcPrice(price);
//            System.out.println(customer.getCustomerName() + "님이 " + cost + "원 지불했음");
//            System.out.println(customer.getCustomerName() + "님의 현재 보너스 포인트는 " + customer.bonusPoint + "입니다." );
//        }
        if( customerE instanceof VIPCustomer ) {
            VIPCustomer vc = (VIPCustomer) customerE;
        }

        if( customerE instanceof GoldCustomer ) {
            GoldCustomer vc = (GoldCustomer) customerE;
            System.out.println(customerE.showCustomerInfo());
        }



    }



}