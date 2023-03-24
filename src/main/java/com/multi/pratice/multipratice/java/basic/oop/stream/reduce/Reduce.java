package com.multi.pratice.multipratice.java.basic.oop.stream.reduce;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.stream
 * fileName : Reduce
 * author : taeil
 * date : 2023/03/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/24        taeil                   최초생성
 */
public class Reduce {
    // 연산 수행에 대한 구현을 할 수 있는 reduce()연산
    // 정의된 연산이 아닌 프로그래머가 직접 구현한 연산을 적용함
    // T reduce(T identify, BinaryOperator<T> accumulator); --> 람다를 직접 적용할수도있음

    // 최종 연산으로 스트림의 요소를 소모하며 연산을 수행한다.

    // 배열의 모든 요소의 합을 구하는 reduce() 연산 구현 예시
    // Arrays.stream(arr).reduce(0, (a,b) -> a+b)); -> 0은 초기값, 매개 변수 전달 됐을때 두개를 더해라.

    // reduce() 메서드의 두 번째 요소로 전달되는 람다식에 따라 다양한 기능을 수행 할 수 있음
    // 람다식을 직접 구현하거나 람다식이 긴 경우 BinaryOperator를 구현한 클래스를 사용


}