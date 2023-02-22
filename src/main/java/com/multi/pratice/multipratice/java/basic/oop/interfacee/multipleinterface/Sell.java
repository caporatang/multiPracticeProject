package com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface;

public interface Sell {

    void sell();
    default void order() {
        System.out.println("sell order");
    }
}
