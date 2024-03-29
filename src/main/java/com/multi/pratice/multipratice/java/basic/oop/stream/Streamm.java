package com.multi.pratice.multipratice.java.basic.oop.stream;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop
 * fileName : Streamm
 * author : taeil
 * date : 2023/03/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/23        taeil                   최초생성
 */
public class Streamm {
    // 스트림이란?
    // 1. 자료의 대상과 관계없이 동일한 연산을 수행
    //  -> 배열, 컬렉션을 대상으로 연산을 수행
    //  -> 일관성 있는 연산으로 자료의 처리를 쉽고 간단하게 함 ->  자료 처리에 대한 추상화가 구현되었다고 한다

    // 2. 한번 생성하고 사용한 스트림은 재사용 할 수 없음
    // -> 자료에 대한 스트림을 생성하여 연산을 수행하면 스트림은 소모된다.
    // -> 다른 연산을 수행하기 위해서는 스트림을 다시 생성해야 한다.

    // 3. 스트림 연산은 기존 자료를 변경하지 않는다.
    // -> 자료에 대한 스트림을 생성하면 스트림이 사용하는 메모리 공간은 별도로 생성 되므로 연산이 수행 되도 기존 자려에 대한 변경은 발생 하지 않는다.

    // 4. 스트림 연산은 중간 연산과 최종 연산으로 구분한다.
    // -> 스트림에 대해 중간 연산은 여러 개의 연산이 적용될 수 있지만 최종 연산은 마지막에 한 번만 적용된다.
    // -> 최종연산이 호출되어야 중ㅇ간 연산에 대한 수행이 이루어 지고 그 결과가 만들어진다.
    // -> 따라서 중간 연산에 대한 결과를 연산 중에 알수없다 -> 이를 '지연 연산'이라고 한다.

}