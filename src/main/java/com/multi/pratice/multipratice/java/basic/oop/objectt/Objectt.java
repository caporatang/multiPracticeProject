package com.multi.pratice.multipratice.java.basic.oop.objectt;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.objectt
 * fileName : Objectt
 * author : taeil
 * date : 2023/02/09
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/09        taeil                   최초생성
 */
public class Objectt {
    // Object class
    // object 클래스는 java.lang 패키지에 속함
    // 프로그래밍시 import 하지 않아도 자동으로 import된다. -> 많이 사용하는 기본 클래스들이 속함(String Integer System)

    // 모든 클래스는 Object 클래스를 상속 받는다
    // java.lang.Object 클래스
    // 모든 클래스의 최상위 클래스 -> 모든 클래스는 Object에서 상속받고, Object 클래스의 메서드 중 일부는 재정의해서 사용가능
    // 명시되어 있지 않아도 extends Object를 추가하는것임

    // Object 클래스의 메서드 활용
    // equals() 메서드
    // 두 인스턴스의 주소 값을 비교하여 true/false를 반환
    // 재정의 하여 두 인스턴스가 논리적으로 동일함의 여부를 구현함
    // 인스턴스가 다르더라도 논리적으로 동일한 경우 true를 반환하도록 재정의 할 수 있음(ex -> 같은 학번, 같은 사번, 같은 아이디의 회원)

    // hashCode() 메서드
    // hashCode()는 인스턴스의 저장 주소를 반환.
    // 힙메모리에 인스턴스가 저장되는 방식이 hash 방식이다.
    // hash -> 정보를 저장, 검색하는 자료구조임
    // 자료의 특정 값(키 값)에 대한 저장 위치를 반환해주는 해시 함수를 사용한다
    // index = hash(key)
    // 저장위치  해시함수(객체정보)

    // equals, hashCode 두개의 함수는 pair로 사용해야함
    // String 클래스에도 이미 equals가 override되어 있음, 그래서 String.equals() 문자열을 넣었을때 true가 반환되는것임

    // Clone() method
    // 객체의 원본을 복제하는데 사용하는 메서드
    // 생성과정의 복잡한 과정을 반복하지 않고 복제 할 수 있음
    // 객체의 정보(맴버 변수 값 등...) 동일한 또 다른 인스턴스가 생성되는것이다. -> 객체지향에서 정보은닉, 객체 보호 관점에서 위배될수있다.
    // 해당 클래스의 clone() 메서드의 사용을 허용한다는 의미로 cloneable 인터페이스를 명시해준다. implements Cloneable
}