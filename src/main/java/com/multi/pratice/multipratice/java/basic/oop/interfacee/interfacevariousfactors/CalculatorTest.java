package com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacevariousfactors;


import com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacevariousfactors.CompleteCalc;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee
 * fileName : CalculatorTest
 * author : taeil
 * date : 2023/02/05
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/05        taeil                   최초생성
 */
public class CalculatorTest {

    public static void main(String[] args) {
     /* int num1 = 10;
        int num2 = 2;

        // Calc calc = new CompleteCalc();

        CompleteCalc calc = new CompleteCalc();
        System.out.println(calc.add(num1, num2));
        System.out.println(calc.substract(num1, num2));
        System.out.println(calc.times(num1, num2));
        System.out.println(calc.divide(num1, num2));

        calc.showInfo();
     */
        // static
        int[] arr = {1,2,3,4,5};
        System.out.println(Calc.total(arr));

        // default
        CompleteCalc defaultCalc = new CompleteCalc();
        defaultCalc.description();



    }
}