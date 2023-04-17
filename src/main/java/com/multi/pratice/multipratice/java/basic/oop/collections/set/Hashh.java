package com.multi.pratice.multipratice.java.basic.oop.collections.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.collections.set
 * fileName : HashSet
 * author : taeil
 * date : 2023/04/17
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/17        taeil                   최초생성
 */
public class Hashh {
    public static void main(String[] args) {
        // HashSet은 내부적으로 중복 체크를 HashCode() 메서드로 hash값으로 비교한 후
        // Hash값이 일치한다면 equals 메서드를 호출해서 비교한 다음 중복값을 체크한다
        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("b"); // -> set에 중복 저장 불가
        set.add("d");

        System.out.println("Set 크기 확인 : " + set.size());

        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) { // iterator에 다음 값이 있다면,
            System.out.println("iterator : " + iter.next()); // -> iter객체에서 데이터 꺼내기
        }

        // LinkedSet
        //다른 Set들과 동일하게 중복은 허용하지 않으나 추가한 순서대로 값이 저장된다 --> 사용법은 HashSet과 동일하다

        // TreeSet
        // 오름 차순으로 값을 정렬해서 가지고 있으며, 정렬이 되어 있는 만큼 검색시 성능이 빠름
        TreeSet<Integer> ts = new TreeSet<>(); // Integer타입으로 오름차순 정렬
        // Integer 타입으로 내림차순 정렬
        TreeSet<Integer> ts2 = new TreeSet<>(Collections.reverseOrder());
        // String 타입으로 오름차순 정렬
        TreeSet<String> ts3 = new TreeSet<>();
        // String 타입으로 내림차순 정렬
        TreeSet<String> ts4 = new TreeSet<>(Collections.reverseOrder());

        ts.add(1); // 추가 <--> 삭제는 remove() --> 전체 삭제는 clear
        ts.add(2);

        // Iterator를 사용하여 출력 
        Iterator iterator = ts.iterator();
        while(iter.hasNext())
            System.out.print(iter.next() + " ");
    }

}