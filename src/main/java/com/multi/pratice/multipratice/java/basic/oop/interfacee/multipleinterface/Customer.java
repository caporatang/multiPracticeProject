package com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface
 * fileName : Customer
 * author : taeil
 * date : 2023/02/08
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/08        taeil                   최초생성
 */
public class Customer implements Buy, Sell{

    @Override
    public void sell() {
        System.out.println("cusomter sell");
    }

    @Override
    public void buy() {
        System.out.println("cusomter buy");
    }

    @Override
    public void order() {
        System.out.println("customer order");
    }

    public void hello() {
        System.out.println("hello");
    }



}