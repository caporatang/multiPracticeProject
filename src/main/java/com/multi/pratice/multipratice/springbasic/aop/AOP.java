package com.multi.pratice.multipratice.springbasic.aop;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.aop
 * fileName : AOP
 * author : taeil
 * date : 2023/02/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/24        taeil                   최초생성
 */
public class AOP {
    // 관점지향 프로그램
    // 스프링은 특별한 경우를 제외 하고는 MVC 웹 어플리케이션에서는 Web Layer, Business Layer, Data Layer로 정의
    // - Web Layer : REST API를 제공, Client 중심의 로직 적용
    // - Business Layer : 내부 정책에 따른 logic을 개발
    // - Data Layer : 데이터 베이스 및 외부와의 연동을 처리

    // 횡단 관심 --> AOP는 메서드, 특정구역에 반복되는 로직들을 하곳으로 몰아서 코딩 할 수있게 해줌
    // Method Parameter Log, 실행시간 Log, Parameter Encode 등..


    // 주요 Annotation
    // @Aspect : 자바에서 사용하는 AOP 프레임워크에 포함되며, AOP를 정의하는 Class에 할당
    // @Pointcut : 기능을 어디에 적용시킬지, 메소드나 Annotation 등 AOP를 적용 시킬 지점을 설정
    // @Before : 메서드 실행하기 이전
    // @After : 메서드가 성공적으로 실행 후, 예외가 발생 되더라도 실행
    // @AfterReturning : 메서드 호출 성공 실행 시 (Not Throws)
    // @AfterThrowing : 메서드 호출 실패 예외 발생 (Throws)
    // @Around : Before / After 모두 제어



}