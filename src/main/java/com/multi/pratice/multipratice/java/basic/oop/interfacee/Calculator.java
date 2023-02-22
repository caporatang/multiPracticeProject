package com.multi.pratice.multipratice.java.basic.oop.interfacee;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee
 * fileName : Calculator
 * author : taeil
 * date : 2023/02/05
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/05        taeil                   최초생성
 */
public abstract class Calculator implements Calc{

    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int substract(int num1, int num2) {
        return num1 - num2;
    }
}