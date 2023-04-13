package com.multi.pratice.multipratice.jpa.domain.mappedbytest.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MapTestServiceTest {

    @Autowired
    private MapTestService mapTestService;

    @Test
    @DisplayName("mappedBy 테스트")
    void mappedByTest() {
        mapTestService.mappedByTest();
    }

    @Test
    @DisplayName("편의 메서드 테스트")
    void ConvenienceMethodTest() {
        mapTestService.ConvenienceMethodTest();
    }

}