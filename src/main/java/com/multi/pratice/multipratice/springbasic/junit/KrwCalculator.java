package com.multi.pratice.multipratice.springbasic.junit;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.junit
 * fileName : KrwCalculator
 * author : taeil
 * date : 2023/03/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/02        taeil                   최초생성
 */
public class KrwCalculator implements ICalculator {

    private int price = 1;

    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x *= price;
        y *= price;
        return x - y;
    }
}