package com.multi.pratice.multipratice.springbasic.interceptor.handler;

import com.multi.pratice.multipratice.springbasic.interceptor.exception.NotNameMatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.interceptor.handler
 * fileName : GlobalExceptionHandler
 * author : taeil
 * date : 2023/02/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/28        taeil                   최초생성
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotNameMatchException.class)
    public ResponseEntity NotNameMatchException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}