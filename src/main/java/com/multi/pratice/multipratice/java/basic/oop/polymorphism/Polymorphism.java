package com.multi.pratice.multipratice.java.basic.oop.polymorphism;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.polymorphism
 * fileName : Polymorphism
 * author : taeil
 * date : 2023/01/29
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/29        taeil                   최초생성
 */
public class Polymorphism {
    // 다형성이란 ?
    // 하나의 코드가 여러 자료형으로 구현 되어 실행
    // 같은 코드에서 여러 다른 실행 결과를 얻을수있음
    // 정보은닉, 상속과 더불어 oop의 가장 큰 특징 중 하나

    // 사용 이유 : 상속과 메서드 재정의를 활용하여 확장성 있는 프로그램을 만들 수 있음 --> 사용하지 않으면 많은 if-else if 문이 구현이 되기 때문에 유지보수가 어려워질수있음..!

    // ------------------------------ 그래서 상속은 언제 사용해야 좋은건데? ----------------------------
    // IS - A(inheritance)관계
    // 일반적인 개념과 구체적인 개념과의 관계
    // 상위 클래스 : 하위 클래스보다 일반적인 개념
    // 하위 클래스 : 상위 클래스보다 구체적인 개념들이 더해진다.
    // 상속은 클래스간의 결합도 자체가 높은 설계
    // 상위클래스의 수정이 많은 하위 클래스에 영향을 미칠 수 있다.
    // 계층구조가 복잡하거나 hierachy가 높으면 좋지 않다.

    // HAS -A(composition) 관계
    // 클래스가 다른 클래스를 포함하는 관계(변수로 선언한다)
    // 코드 재사용의 가장 일반적인 방법이다
    // Student가 Subject를 포함하는,
    // Library를 구현할 때 ArrayList 생성하여 사용한다.
    // 상속하지 않는다.


}