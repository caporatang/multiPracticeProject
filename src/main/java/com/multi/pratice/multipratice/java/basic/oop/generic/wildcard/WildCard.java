package com.multi.pratice.multipratice.java.basic.oop.generic.wildcard;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.generic.wildcard
 * fileName : WildCard
 * author : taeil
 * date : 2023/02/15
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/15        taeil                   최초생성
 */
public class WildCard {
    // 와일드카드란?
    // 하나의 참조 변수로 대입된 타입이 다른 객체를 참조 가능하게 한다.

    // <? extends T> --> 와일드 카드의 상한 제한 -> T 와 그 자손들만 가능
    // <? super T> --> 와일드 카드 하한 제한 -> T와 그 조상들만 가능
    // <?> --> 제한 없음 모든 타입으로 가능하다 --> 모든 클래스의 최상위는 Object 이므로 < ? extends Object> 와 동일하다.

    // 만들어둔 Heavy, Diet , Protein, SweetPotato 클래스를 예로 들어보자
    // Object --> Heavy --> Diet --> Protein, SweetPotato
    // < ? extends Diet > -> Diet와 Protein, SweetPotato 그 외 생성될 자손들까지 타입을 대입시킬수있음
    // < ? super Diet >  -> Diet를 포함한 상위 클래스(Heavy, Object)
    // < ? > --> 제한없이 모두 가능 !

    // 이중에 가장 빈번하게 사용되는것은 -> ? extends T
}