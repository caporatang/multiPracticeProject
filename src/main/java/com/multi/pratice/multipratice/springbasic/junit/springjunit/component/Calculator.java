package com.multi.pratice.multipratice.springbasic.junit.springjunit.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
@Component
@RequiredArgsConstructor
public class Calculator {
    private final ICalculator iCalculator;

    public int sum(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.sum(x,y);
    }

    public int minus(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.minus(x, y);
    }

}