package com.multi.pratice.multipratice.java.basic.oop.compareto;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.compareto
 * fileName : Comparator
 * author : taeil
 * date : 2023/06/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/06/28        taeil                   최초생성
 */
interface Comparator<T> {
    // compareTo 메서드를 여러개 재정의 할 수 없는데 비교 기준이 여러개인 경우가 생긴다면, Comparator의 compare 메서드를 재정의 한다
    int compare(T obj1, T obj2);

    // Comparator는 compare 메서드를 오버라이딩 해야한다.
    // compare 메서드는 파라미터 두개로 두개의 객체를 받아서 서로 비교해주면 된다.
    // Comparator 인터페이스는 비교 기준이 여러 개 일때 사용하는 인터페이스기에 비교할 클래스에 구현하지말고, 따로 클래스를 구현해주는게 좋다.

}