package com.multi.pratice.multipratice.springbasic.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.exception.advice
 * fileName : GlobalControllerAdvice
 * author : taeil
 * date : 2023/02/27
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/27        taeil                   최초생성
 */

// 지정한 패키지 컨트롤러 exception 잡기
//@RestControllerAdvice(basePackages = "com.multi.pratice.multipratice.springbasic.exception.controller")
@RestControllerAdvice
public class GlobalControllerAdvice {
    // 컨트롤러에서 발생되는 전체 에러를 핸들링


    @ExceptionHandler(value = Exception.class) // -> 발생되는 모든 Exception을 잡을것임
    public ResponseEntity exception(Exception e) {
        System.out.println(e.getClass().getName());

        // 메세지 내용 출력
        System.out.println("---------------------------------");
        System.out.println(e.getLocalizedMessage());
        System.out.println("---------------------------------");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    // 특정 exception을 잡아보자
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println("나는 글로벌 캐치");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}