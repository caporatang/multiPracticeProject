package com.multi.pratice.multipratice.springbasic.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.ioc
 * fileName : Encoder
 * author : taeil
 * date : 2023/02/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/23        taeil                   최초생성
 */

public class Encoder  {

    private IEncoder iEncoder;

//    public Encoder(@Qualifier("base74Encoder") IEncoder iEncoder) {
    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String encode(String message) {
        return iEncoder.encode(message);
    }

    public void setiEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }


}