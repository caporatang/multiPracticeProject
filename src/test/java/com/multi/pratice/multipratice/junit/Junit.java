package com.multi.pratice.multipratice.junit;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;

/**
 * packageName : com.multi.pratice.multipratice.junit
 * fileName : Junit
 * author : taeil
 * date : 2023/04/12
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/12        taeil                   최초생성
 */
public class Junit {
    // JUnit5 어노테이션
    // @Test : 테스트 Method임을 선언
    // @ParameterizedTest : 매개변수를 받는 테스트 작성
    // @RepeatedTest : 반복되는 테스트 작성
    // @TestFactory : 동적으로 테스트를 사용함
    // @Test : 정적 테스트
    // @TestInstance : 테스트 클래스의 생명주기 설정
    // @TestTemplate : 공급자에 의해 여러 번 호출될 수 있도록 설계된 테스트 케이스 템플릿임을 나타냄
    // @TestMethodOrder : 테스트 메소드 실행 순서 구성에 사용
    // @DisplayName : 테스트 클래스 or 메소드의 사용자 정의 이름 선언
    // @DisplayNameGeneration : 이름 생성기 선언
    // ex) '_'를 공백 문자로 치환해주는 생성기
    // new_test -> new test
    // @BeforeEach : 모든 테스트 실행 전에 실행할 테스트
    // JUnit4에서는 @Before
    // @AfterEach : 모든 테스트 실행 후에 실행할 테스트
    // JUnit4에서는 @After
    // @BeforeAll : 현재 클래스 실행 전 제일 먼저 실행할 테스트
    // static으로 선언
    // JUnit4에서는 @BeforeClass
    // @AfterAll : 현재 클래스 종료 직후 실행할 테스트
    // static으로 선언
    // JUnit4에서는 @AfterClass
    // @Nested : (정적이 아닌) 중첩 테스트 클래스
    // @Tag : 클래스 or 메소드 레벨에서 태그 선언
    // @Disabled : 이 클래스나 테스트를 사용하지 않음
    // JUnit4에서는 @Ignore
    // @Timeout : 테스트 실행 시간 선언, 초과되면 실패하도록 설정
    // @ExtendWith : 확장을 선언적으로 등록할 때 사용
    // @RegisterExtension : 필드를 통해 프로그래밍 방식으로 확장을 등록할 때 사용
    // @TempDir : 필드 주입 or 매개변수 주입을 통해 임시 디렉토리 제공
}