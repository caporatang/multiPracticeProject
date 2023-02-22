package com.multi.pratice.multipratice.springbasic.designpattern.strategy;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.strategy
 * fileName : Encoder
 * author : taeil
 * date : 2023/02/21
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/21        taeil                   최초생성
 */
public class Encoder {

    private EncodingStrategy encodingStrategy;

    public String getMessage(String message) {
        return this.encodingStrategy.encode(message);
    }

    public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
        this.encodingStrategy = encodingStrategy;
    }
}