package com.multi.pratice.multipratice.springbasic.junit.springjunit.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.junit
 * fileName : DollarCalculator
 * author : taeil
 * date : 2023/03/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/02        taeil                   최초생성
 */
@Component
@RequiredArgsConstructor
public class DollarCalculator implements ICalculator {
    private int price = 1;
    private final MarketApi marketApi;

    @Override
    public void init() {
        this.price = marketApi.connect();
    }


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