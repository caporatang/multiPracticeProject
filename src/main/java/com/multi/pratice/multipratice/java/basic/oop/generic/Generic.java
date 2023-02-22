package com.multi.pratice.multipratice.java.basic.oop.generic;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.generic
 * fileName : Generic
 * author : taeil
 * date : 2023/02/15
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/15        taeil                   최초생성
 */
public class Generic {
    // 제네릭 자료형 이란?
    // 클래스에서 사용하는 변수의 자료형이 여러개 일수 있고,
    // 그 기능(메서드)은 동일한 경우 클래스의 자료형을 특정하지 않고 추후 해당 클래스를 사용할 때 지정 할 수 있도록 선언하는것.
    // 실제 사용되는 자료형의 변환은 컴파일러에 의해 검증되므로 안정적인 프로그래밍 방식임
    // 컬렉션 프레임워크에서 많이 사용된다

    // 제네릭은 자료형 매개변수(T) 를 사용 --> Type Parameter의 약자로 T를 사용
    // --> 이 클래스를 사용하는 시점에 실제 사용할 자료형을 지정, static 변수는 사용할 수 없다

    // 다이아몬드 연산자 < >
    // ArrayList list = new ArrayList<>(); -> 다이아몬드 연산자 내부에서 자료형은 생략이 가능하다.

    // 제네릭에서 자료형 추론(java 10 이후로만 가능) --> 지역변수 자료형 추론
    // ArrayList list = new ArrayList() ==> var list = new ArrayList();






}