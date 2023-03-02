package com.multi.pratice.multipratice.component;

import com.multi.pratice.multipratice.springbasic.junit.springjunit.component.Calculator;
import com.multi.pratice.multipratice.springbasic.junit.springjunit.component.DollarCalculator;
import com.multi.pratice.multipratice.springbasic.junit.springjunit.component.MarketApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

/**
 * packageName : com.multi.pratice.multipratice
 * fileName : DollarCalculatorTest
 * author : taeil
 * date : 2023/03/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/02        taeil                   최초생성
 */
@SpringBootTest // -> 통합테스트 모든 bean을 올려놓고 테스트
public class DollarCalculatorTest {
    // 스프링에서 사용할때는 bean으로 관리 되는것만 기억하면 기본 자바랑 같음

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private Calculator calculator;


    @Test
    public void dollarCalculatorTest() {

        Mockito.when(marketApi.connect()).thenReturn(3000);

        int sum = calculator.sum(10,10);
        int minus = calculator.minus(10,10);

        // 예측값, 기대값
        Assertions.assertEquals(60000, sum);
        Assertions.assertEquals(0, minus);
    }




}