package com.multi.pratice.multipratice.java.basic.oop.exception.customexception;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.exception.customexception
 * fileName : PasswordException
 * author : taeil
 * date : 2023/03/25
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/25        taeil                   최초생성
 */
public class PasswordException extends Exception{
    // IllegalArgumentException --> 아규먼츠에 에러가 있는 경우

    public PasswordException(String message) {
        super(message);
    }

}