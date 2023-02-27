package com.multi.pratice.multipratice.springbasic.exception;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.exception
 * fileName : SpringException
 * author : taeil
 * date : 2023/02/27
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/27        taeil                   최초생성
 */
public class SpringException {
    // Web Application의 입장에서 바라 보았을때, 에러가 났을 때 내려줄 수 있는 방법은 많지 않다
    // 1. 에러 페이지
    // 2. 4XX Error or 5XX Error
    // 3. Client가 200 외에 처리를 하지 못 할 때는 200을 내려주고 별도의 에러 Message 전달

    // 2가지 방식으로 처리 가능
    // @ControllerAdvice : Global 예외 처리 및, 특정 package / controller 예외처리
    // @ExceptionHandler : 특정 Controller의 예외처리
}