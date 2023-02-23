package com.multi.pratice.multipratice.springbasic.di;

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

    public Encoder(IEncoder iEncoder) {
        // this.iEncoder = new Base64Encoder();
        this.iEncoder = iEncoder;
    }


    public String encode(String message) {
        return iEncoder.encode(message);
    }


}