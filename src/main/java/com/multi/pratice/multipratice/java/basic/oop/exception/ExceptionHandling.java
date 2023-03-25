package com.multi.pratice.multipratice.java.basic.oop.exception;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.exception
 * fileName : ExceptionHandling
 * author : taeil
 * date : 2023/03/25
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/25        taeil                   최초생성
 */
public class ExceptionHandling {
    // 프로그램에서의 오류
    // 컴파일 오류 -> 프로그램 코드 작성 중 발생하는 문법적 오류, 최근에는 개발환경에서 대부분의 컴파일 오류는 detection 된다.
    // 실행 오류 -> 실행 중인 프로그램이 의도 하지 않은 동작을 하거나 프로그램이 중지 되는 오류, 실행 오류는 비정상 종료가 되는 경우 시스템의 심각한 장애를 발생할 수 있음

    // 예외 처리의 중요성
    // 프로그램의 비정상 조료를 피하여 시스템이 원할이 실행 되도록 함
    // 실행 오류가 발생한 경우 오류의 과정을 재현하는 것은 현실적으로 힘들다.
    // 오류가 발생한 경우 log를 남겨서 추후 log 분석을 통해 그 원인을 파악하여 bug를 수정하는 것이 중요하다.

    // 오류와 예외 클래스
    // 시스템 오류(error) : 가상 머신에서 발생, 프로그래머가 처리 할 수 없는 오류 -> 동적 메모리가 없는 경우, 스택 메모리 오버플로우 등..
    // 예외(Exception) : 프로그램에서 제어 할 수 있는 오류 -> 읽어들이려는 파일이 존재하지 않거나, 네트웍이나 DB연결이 안되는 경우 등..

    // 자바는 안정성이 중요한 언어로 대부분 프로그램에서 발생하는 오류에 대해 문법적으로 예외 처리를 해야한다.
    // Throwable <- Error - Exception

}