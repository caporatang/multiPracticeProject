package com.multi.pratice.multipratice.springbasic.designpattern.strategy;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.strategy
 * fileName : AppendStrategy
 * author : taeil
 * date : 2023/02/21
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/21        taeil                   최초생성
 */
public class AppendStrategy implements EncodingStrategy {
    @Override
    public String encode(String text) {
        return "ABCD" + text;
    }
}