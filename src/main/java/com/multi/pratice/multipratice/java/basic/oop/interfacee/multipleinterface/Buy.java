package com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface;

public interface Buy {
    void buy();

    default void order() {
        System.out.println("buy order");
    }
}
