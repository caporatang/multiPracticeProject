package com.multi.pratice.multipratice.springbasic.basicoop;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.basicoop
 * fileName : POJOJava
 * author : taeil
 * date : 2023/02/26
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/26        taeil                   최초생성
 */
public class POJOJava {
    // POJO (Plain Old Java Object)
    // 순수 자바 오브젝트
    // 예전엔 EJB(Enterprise Java Bean)을 활용하여 개발을 진행 -> EJB에 종속적인 부분이 많았음
    // EJB에 의존을 너무 하다보니 Module교체, 시스템 업그레이드시 종속성으로 인하여 불편함이 발생됨

    // POJO 특징
    // 1. 특정 규약에 종속 되지 않는다.
    // --> 특정 Library, Module에서 정의된 클래스를 상속받아 구현하지 않아도 된다. POJO가 되기 위해서는 외부의 의존성을 두지 않고, 순수한 JAVA로 구성 가능 해야한다.
    // 2. 특정 환경에 종속되지 않는다.
    // --> 만일 특정 비즈니스 로직을 처리 하는 부분에 외부 종속적인 http request, session등 POJO를 위배한 것으로 간주
    // 또한 많이 사용하고는 있지만 @Annotation 기반으로 설정하는 부분도 엄연히 따지면 POJO라고 볼수없음

    // POJO Framework
    // 1. Spring, Hibernate
    // --> 하나의 서비스를 개발하기 위해서는, 시스템의 복잡함, 비즈니스 로직의 복잠함 등 어려움이 많음
    // -> Spring과 Hibernate는 객체지향적인 설계를 하고 있으며, 또한 POJO를 지향하고 있음


}