package com.multi.pratice.multipratice.java.basic.oop.objectt.classclass;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.objectt.classclass
 * fileName : Classs
 * author : taeil
 * date : 2023/02/12
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/12        taeil                   최초생성
 */
public class Classs {
    // 자바의 모든 클래스와 인터페이스는 컴파일 후 class 파일이 생성됨
    // Class 클래스는 컴파일 된 class 파일을 로드하여 객체를 동적 로드하고, 정보를 가져오는 메서드가 제공된다.
    // ClassforName("클래스 이름") 메서드로 클래스를 동적으로 로드 함

    // 동적 로딩 --> mapping
    // 컴파일 시에 데이터 타입이 binding 되는 것이 아닌, 실행(runtime) 중에 데이터 타입을 binding하는 방법
    // 프로그래밍 시에는 문자열 변수로 처리했다가 런타임시에 원하는 클래스를 로딩하여 binding 할 수 있다는 장점이 있음.
    // 컴파일 시에 타입이 정해지지 않으므로 동적 로딩시 오류가 발생하면 프로그램의 심각한 장애가 발생될수도있음..

    // Class의 newInstance()메서드로 인스턴스 생성
    // -> new 키워드를 사용하지 않고 클래스 정보를 활용하여 인스턴스를 생성할 수 있음

    // 클래스 정보
    // reflection 프로그래밍 : Class 클래스를 사용하여 클래스의 정보(생성자, 변수, 메서드) 등을 알 수 있고 인스턴스를 생성하고 메서드를 호출하는 방식
    // 로컬 메모리에 객체 없는 경우에 원격프로그래밍, 객체의 타입을 알 수 없는 경우에 사용함
    // java.lang.reflect 패키지에 있는 클래스를 활용하여 프로그래밍
    // 일반적으로 자료형을 알고 있는 경우엔 사용하지 않는다.
    // 같은 머신을 사용하더라도, 다른 메모리를 가진 프로그램 두개라면, 해당 방식으로 프로그래밍을 할수도있음

}