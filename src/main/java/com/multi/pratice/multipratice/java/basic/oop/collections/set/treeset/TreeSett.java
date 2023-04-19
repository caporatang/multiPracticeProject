package com.multi.pratice.multipratice.java.basic.oop.collections.set.treeset;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.collections.set.treeset
 * fileName : Comparable
 * author : taeil
 * date : 2023/04/19
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/19        taeil                   최초생성
 */
public class TreeSett {
    // Comparable, Comparator
    // 객체의 정렬에 사용하는 클래스임
    // Set 인터페이스를 구현하여 중복을 허용하지 않고, 오름차순이나 내림차순으로 객체를 정렬할 수 있음
    // 내부적으로 이진검색트리로 구현된다
    // 이진검색트리에 저장하기 위해 각 객체를 비교해야 함
    // 비교 대상이 되는 객체에 Comparable, Comparator 인터페이스를 구현 해야 TreeSet에 추가 될 수 있음
    // String, Integer등 JDK의 많은 클래스들이 이미 Comparable을 구현하여 사용중이다.

    // 비교를 어떻게 할지를 따로 구현 해주어야함
    // 엘레먼트가 \추가 될 때 마다 기존 tree구조에 있는 node들과 비교를 통해서 동일하면 중복이 허용되지 않기 때문에 못들어가고,
    // tree구조에 있는 어디에 위치 시킬지를 구현 해야함

}