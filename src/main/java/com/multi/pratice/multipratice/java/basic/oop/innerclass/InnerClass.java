package com.multi.pratice.multipratice.java.basic.oop.innerclass;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.innerclass
 * fileName : InnerClass
 * author : taeil
 * date : 2023/02/13
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/13        taeil                   최초생성
 */
public class InnerClass {
    // 클래스 내부에 선언한 클래스로 이 클래스를 감싸고 있는 외부 클래스와 밀접한 연관이 있는 경우가 많고,
    // 다른 외부 클래스에서 사용할 일이 거의 없는 경우에 내부 클래스로 선언해서 사용하고, 중첩 클래스라고도 함

    // 내부 클래스의 종류 --> 가장 많이 사용되는건 익명 내부 클래스
    // 인스턴스 내부 클래스, 정적(static) 내부 클래스, 지역(local) 내부 클래스, 익명(anonymous) 내부 클래스

    // 인스턴스 내부 클래스
    // 내부적으로 사용할 클래스를 선언(private으로 선언하는 것을 권장)
    // 외부 클래스가 생성된 후 생성된다.(정적 내부 클래스와는 다르다)
    // private이 아닌 내부 클래스는 다른 외부 클래스에서 생성할 수 있다. --> 권장하지 않고 잘 사용하지 않음

    // 정적 내부 클래스
    // 외부 클래스 생성과 무관하게 사용할 수 있음
    // 정적 변수, 정적 메서드 사용

    // 지역 내부 클래스
    // 지역 변수와 같이 메서드 내부에서 정의하여 사용하는 클래스
    // 메서드의 호출이 끝나면 메서드에 사용된 지역변수의 유효성은 사라짐
    // 메서드 호출 이후에도 사용해야 하는 경우가 있을 수 있으므로 지역 내부 클래스에서 사용하는 메서드의 지역 변수나 매개변수는 final로 선언된다.

    // 익명 내부 클래스
    // 이름이 없는 클래스 (위 지역 내부 클래스 Runnable 클래스 이름은 실제로 호출되는 경우가 없음)
    // 클래스의 이름을 생략하고 주로 하나의 인터페이스나 하나의 추상 클래스를 구현하여 반환한다.
    // 인터페이스나 추상 클래스 자료형의 변수에 직접 대입하여 클래스를 생성하거나 지역 내부 클래스의 메서드 내부에서 생성하여 반환 가능하다.
    // 람다, 안드로이드 온클릭리스너 등 사용되는곳이 많다..! --> 이미 우리가 코딩하면서 써본 케이스도 많음

}