package com.multi.pratice.multipratice.jpa;

/**
 * packageName : com.multi.pratice.multipratice.jpa
 * fileName : Transactional
 * author : taeil
 * date : 2023/03/20
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/20        taeil                   최초생성
 */
public class Transactional {
    // 트랜잭션이란? DB의 명령어들의 논리적인 묶음 -> 자바로 예를 들면 메서드가 있다.

    // 물건을 구매하는 행위 -> 물건을 결제하는 행위 + 물건이 구입되는 행위가 동시에 일어나야함
    // 결제만 되거나, 물건이 구입이 되지 않으면 안된다. -> 논리적으로 하나의 트랜잭션에서 처리 되어야함

    // 데이터베이스 트랜잭션이란? ACID
    // A Atomicity 원자성 : 부분적인 성공을 허용하지 않는다.
    // C Consistency 일관성 : 일관성은 데이터베이스의 상태가 일관되어야 한다는 성질이다.
    // I Isolation 독립성 : 트랜잭션내의 데이터 조작에 있어서는, 다른 트랜잭션으로부터 독립적인 특성을 갖게 된다.
    // D Durablility 지속성 : 데이터는 영구적으로 보관된다.

}