package com.multi.pratice.multipratice.springbasic.di;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.iocdi
 * fileName : IoC
 * author : taeil
 * date : 2023/02/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/23        taeil                   최초생성
 */
public class Di {
    // IoC (Inversion of Control)
    // 스프링에서는 일반적인 Java 객체를 new로 생성하여 개발자가 관리하는 것이 아닌 Spring Container에 모두 맡김
    // 개발자 -> 프레임워크로 제어의 객체 관리의 권한이 넘어 갔음 -> "제어의 역전"

    // DI (Dependency Injection) -> 의존성 주입 -> 주입을 해주는건 spring Container
    // DI의 장점
    // 의존성으로 부터 격리시켜 코드 테스트에 용이하다.
    // DI를 통하여, 불가능한 상황을 Mock와 같은 기술을 통해 안정적으로 테스트가 가능
    // 코드를 확장하거나 변경 할 때 영향을 최소화함(추상화)
    // 순환참조를 방지할수있음



}