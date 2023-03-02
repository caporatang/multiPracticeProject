package com.multi.pratice.multipratice.springbasic.junit;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.junit
 * fileName : Calculator
 * author : taeil
 * date : 2023/03/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/02        taeil                   최초생성
 */
public class Calculator {
    private ICalculator iCalculator;

    public Calculator (ICalculator iCalculator) {
        this.iCalculator = iCalculator;
    }

    public int sum(int x, int y) {
        return this.iCalculator.sum(x,y);
    }

    public int minus(int x, int y) {
        return this.iCalculator.minus(x, y);
    }

}