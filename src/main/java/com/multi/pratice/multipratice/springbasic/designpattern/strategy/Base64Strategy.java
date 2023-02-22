package com.multi.pratice.multipratice.springbasic.designpattern.strategy;

import java.util.Base64;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.strategy
 * fileName : Base64Strategy
 * author : taeil
 * date : 2023/02/21
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/21        taeil                   최초생성
 */
public class Base64Strategy implements EncodingStrategy {

    @Override
    public String encode(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

}