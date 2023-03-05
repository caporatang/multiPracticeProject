package com.multi.pratice.multipratice.springbasic.resttemplate.dto;

import lombok.*;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.resttemplate.dto
 * fileName : Req
 * author : taeil
 * date : 2023/03/05
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/05        taeil                   최초생성
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Req<T> {
    // 일반적인 JSON 형태가 아닌 경우 --> header는 고정, body 내부에 데이터들만 변동
    // {
    //   "header" : {
    //       "response_code" : ok
    //  },
    //   "body" : {
    //       "name" : "taeil"
    //        age : 10
    //  }
    //}

    private Header header;

    private T resBody;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Header {
        private String responseCode;
    }

}