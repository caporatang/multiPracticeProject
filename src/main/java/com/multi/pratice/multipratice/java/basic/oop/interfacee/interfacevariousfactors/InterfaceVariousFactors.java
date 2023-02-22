package com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacevariousfactors;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacevariousfactors
 * fileName : InterfaceVariousFactors
 * author : taeil
 * date : 2023/02/06
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/06        taeil                   최초생성
 */
public class InterfaceVariousFactors {
    // 인터페이스의 여러가지 요소
    // 상수 -> 모든 변수는 상수로 변환 -> public static final
    // 추상메서드 -> 모든 선언된 메서드는 추상 메서드 public abstract

    // default method 구현을 가지는 메서드, 인터페이스를 구현하는 클래스들에서 공통으로 사용할 수 있다. 구현하는 클래스에서 재정의 가능. 인터페이스를 구현한 클래스의 인스턴스가 생성 되어야 한다.
    // static method  정적 메서드 인스턴스 생성과 상관 없이 인터페이스 타입으로 사용할 수 있는 메서드.

    // java 9버전 이후 제공되는 private 메서드
    // 인터페이스를 구현한 클래스에서 사용하거나 재정의 불가
    // 인터페이스 내부에서만 사용하기 위해 구현하는 메서드
    // default메서드나 static 메서드에서 사용한다


}