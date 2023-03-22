package com.multi.pratice.multipratice.java.basic.oop.lambda;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.lambda
 * fileName : LambdaExpression
 * author : taeil
 * date : 2023/03/22
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/22        taeil                   최초생성
 */
public class LambdaExpression {
    // 함수형 프로그래밍과 람다식
    // 자바는 객체 지향 프로그래밍 : 기능을 수행하기 위해서는 객체를 만들고 그 객체 내부에 멤버 변수를 선언하고 기능을 수행하는 메서드를 구현
    // 자바 8부터 함수형 프로그래밍 방식을 지원하고 이를 람다식이라 함
    // 함수의 구현과 호출만으로 프로그래밍이 수행되는 방식

    // 함수형 프로그래밍 : 함수형 프로그래밍은 순수함수를 구현하고 호출함으로써 외부 자료에 부수적인 사이드 이펙트를 주지 않도록 구현하는 방식
    // 순수 함수란 매개변수만을 사용하여 만드는 함수, -> 즉, 함수 내부에서 함수 외부에 있는 변수를 사용하지 않아 함수가 수행되더라도 외부에는 영향을 주지 않음
    // 함수를 기반으로 하는 프로그래밍이고 입력받는 자료 이외에 외부 자료를 사용하지 않아 여러 자료가 동시에 수행되는 병렬처리 가능
    // 함수형 프로그래밍은 함수의 기능이 자료에 독립적임 --> 다양한 자료에 대해 같은 기능을 수행할 수 있음

    // 두 수를 입력 받아 더하는 add() 익명 함수를 만든다면 ->
    // int add(int x, int y) {
    //  return x+y
    // }

    // 람다식으로 표현
    // (int x, int y) -> {return x+y;}

    // 매개 변수가 하나인 경우 자료형과 괄호 생략가능
    // str -> {System.out.println(str);}

    // 매개변수가 두 개 이상인 경우 괄호를 생략할 수 없음
    // x, y -> {System.out.println(x+y);} -> error!

    // 실행문이 한 문장인 경우 중괄호 생략 가능
    // str -> System.out.println(str);

    // 실행문이 한 문장이라도 return(반환문)은 중괄호를 생략할 수 없음
    // str -> return str.length(); --> error !

    // 실행문이 한 문장의 반환문인 경우엔 return과 중괄호를 모두 생략
    // (x, y) -> x*y;
    // str -> str.length;


}