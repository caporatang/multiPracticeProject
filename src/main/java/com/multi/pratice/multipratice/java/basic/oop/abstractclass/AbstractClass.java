package com.multi.pratice.multipratice.java.basic.oop.abstractclass;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.abstractclass
 * fileName : AbstractClass
 * author : taeil
 * date : 2023/02/01
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/01        taeil                   최초생성
 */
public class AbstractClass {
    // 추상 클래스란?
    // 구현 코드 없이 메서드의 선언만 있는 추상 메서드(abstract method)를 포함한 클래스
    // 메서드 선언 : 반환타입, 메서드 이름, 매개변수로 구성
    // 메서드 정의 : 메서드 구현과 동일한 의미 구현부(body)를 가진다 ({ })
    // ex) int add(int x, int y); 선언
    //     int add(int x, int y){ } 구현부가 있음, 추상 메서드 아님
    // abstract 예약어를 사용
    // 추상 클래스는 인스턴스화 할수없음(new 불가)

    // 추상클래스를 사용하는 이유
    // 상위클래스에서 공통적으로 사용하는 메서드들은 정의해둠
    // 하위클래스에서 어떻게 사용될지 모르는 메서드를 추상메서드로 구현, 하위클래스에게 그 책임을 위임하는것.


}