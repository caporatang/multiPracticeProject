package com.multi.pratice.multipratice.springbasic.junit.springjunit.component;

import org.springframework.stereotype.Component;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.junit
 * fileName : MarketApi
 * author : taeil
 * date : 2023/03/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/02        taeil                   최초생성
 */
@Component
public class MarketApi {

    // 외부 환율을 가져온다고 가정
    public int connect() {
        return 1100;
    }
}