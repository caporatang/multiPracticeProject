package com.multi.pratice.multipratice.springbasic.junit.springjunit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.junit.springjunit.dto
 * fileName : Res
 * author : taeil
 * date : 2023/03/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/02        taeil                   최초생성
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Res {
    private int result;
    private Body response;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Body {
        private String resultCode = "OK";
    }

}