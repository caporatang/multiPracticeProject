package com.multi.pratice.multipratice.springbasic.di;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.ioc
 * fileName : UrlEncoder
 * author : taeil
 * date : 2023/02/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/23        taeil                   최초생성
 */
public class UrlEncoder implements IEncoder {
    public String encode(String message) {
        try {
            return URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

    }
}