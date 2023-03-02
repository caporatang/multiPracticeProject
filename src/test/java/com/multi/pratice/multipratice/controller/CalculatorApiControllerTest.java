package com.multi.pratice.multipratice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multi.pratice.multipratice.springbasic.junit.springjunit.component.Calculator;
import com.multi.pratice.multipratice.springbasic.junit.springjunit.component.DollarCalculator;
import com.multi.pratice.multipratice.springbasic.junit.springjunit.component.MarketApi;
import com.multi.pratice.multipratice.springbasic.junit.springjunit.controller.CalculatorApiController;
import com.multi.pratice.multipratice.springbasic.junit.springjunit.dto.Req;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * packageName : com.multi.pratice.multipratice.controller
 * fileName : CalculatorApiControllerTest
 * author : taeil
 * date : 2023/03/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/02        taeil                   최초생성
 */
@WebMvcTest(CalculatorApiController.class) //-> Web으로 CalculatorApiController만 테스트 할거야
@AutoConfigureWebMvc
@Import({Calculator.class, DollarCalculator.class})
public class CalculatorApiControllerTest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        Mockito.when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void sumTest() throws Exception {
        // get
        mockMvc.perform(
                // 요청보낼 주소
                MockMvcRequestBuilders
                        // == delete
                        .get("http://localhost:8080/calc/sum")
                        .queryParam("x", "10")
                        .queryParam("y","10")
        ).andExpect(
                // 통신 결과
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                //이것 또한 통신 결과인데, 리턴 결과 (body)
                MockMvcResultMatchers.content().string("60000")
        ).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void postMinusTest() throws Exception {
        Req req = new Req();
        req.setX(10);
        req.setY(10);

        // json으로 파싱
        String json = new ObjectMapper().writeValueAsString(req);

        mockMvc.perform(
                // == put
                MockMvcRequestBuilders.post("http://localhost:8080/calc/postminus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                // 기대하는 json값
                // result에 대한 접근
                MockMvcResultMatchers.jsonPath("$.result").value("0")
        ).andExpect(
                // depth가 있는 json에 대한 접근
                MockMvcResultMatchers.jsonPath("$.response.resultCode").value("OK")
        )
        .andDo(MockMvcResultHandlers.print());
    }

}