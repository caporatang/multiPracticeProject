package com.multi.pratice.multipratice.java.basic.oop.compareto.exampleCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.compareto.exampleCode
 * fileName : AnonymousCompare
 * author : taeil
 * date : 2023/06/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/06/28        taeil                   최초생성
 */
public class AnonymousCompare {
    // 재사용을 고려하지 않는다면 익명 클래스를 사용하면 코드를 더 간결하게 짤 수 있다.
    public static void main(String[] args) {
        Person[] people = {new Person(30, "홍길동"), new Person(20, "김철수"), new Person(25, "김영희")};

        // 나이 기준 정렬
        // {20, 김철수}, {25, 김영희}, {30, 홍길동}으로 정렬된다.
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int r = p1.age - p2.age;
                if (r == 0) {
                    r = p1.name.compareTo(p2.name);
                }
                return r;
            }
        });

        // 이름 기준 정렬
        // {25, 김영희}, {20, 김철수}, {30, 홍길동}으로 정렬된다.
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int r = p1.name.compareTo(p2.name);
                if (r == 0) {
                    r = p1.age - p2.age;
                }
                return r;
            }
        });
    }
}