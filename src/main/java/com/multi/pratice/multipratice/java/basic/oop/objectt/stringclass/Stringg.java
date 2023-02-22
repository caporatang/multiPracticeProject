package com.multi.pratice.multipratice.java.basic.oop.objectt.stringclass;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.objectt.stringclass
 * fileName : Stringg
 * author : taeil
 * date : 2023/02/11
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/11        taeil                   최초생성
 */
public class Stringg {
    // String클래스시 유의할점..-> String을 직접적으로 계속 조작을 한다면 메모리 낭비가 생길수있음.
    // 그래서 StringBuilder, StringBuffer를 사용, --> java13부터는 text block을 사용할수있음

    // String 선언 방법
    // 1. String str1 = new String("abc"); --> heap메모리에 인스턴스 생성하는 방법
    // 2. String str2 = "abc"; --> 상수 풀에 있는 주소를 참조하는 방법

    // 한번 생성된 String은 불변이다.
    // String을 연결하면 기존의 String에 연결되는 것이 아닌 새로운 문자열이 생성된다. -> 메모리 낭비가 발생할 가능성이 높음

}