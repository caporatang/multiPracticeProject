package com.multi.pratice.multipratice.java.basic.oop.exception.logger;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.exception.logger
 * fileName : StudentNameFormatException
 * author : taeil
 * date : 2023/03/26
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/26        taeil                   최초생성
 */
public class StudentNameFormatException extends IllegalArgumentException{

    public StudentNameFormatException(String message){
        super(message);
    }
}