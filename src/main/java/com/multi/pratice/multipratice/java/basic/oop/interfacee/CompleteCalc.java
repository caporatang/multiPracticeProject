package com.multi.pratice.multipratice.java.basic.oop.interfacee;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee
 * fileName : CompleteCalc
 * author : taeil
 * date : 2023/02/05
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/05        taeil                   최초생성
 */
public class CompleteCalc extends Calculator {
    @Override
    public int times(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {
        if(num2 == 0)
            return ERROR;

        return num1/num2;
    }

    public void showInfo() {
        System.out.println("모두 구현했습니다");
    }
}