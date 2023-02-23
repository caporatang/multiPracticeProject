package com.multi.pratice.multipratice.springbasic.di;

import java.util.Base64;

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
public class Base64Encoder implements IEncoder {

    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }


}