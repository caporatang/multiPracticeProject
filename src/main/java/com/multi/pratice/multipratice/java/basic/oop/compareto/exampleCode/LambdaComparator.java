package com.multi.pratice.multipratice.java.basic.oop.compareto.exampleCode;

import java.util.Arrays;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.compareto.exampleCode
 * fileName : LambdaComparator
 * author : taeil
 * date : 2023/06/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/06/28        taeil                   최초생성
 */
public class LambdaComparator {
    // 재사용을 고려하지 않는다면 람다를 사용해도 간결하게 작성이 가능하다.
    public static void main(String[] args) {
        Person[] people = {new Person(30, "홍길동"), new Person(20, "김철수"), new Person(25, "김영희")};

        // 나이 기준 정렬
        // {20, 김철수}, {25, 김영희}, {30, 홍길동}으로 정렬된다.
        Arrays.sort(people, (p1, p2) -> {
            int r = p1.age - p2.age;
            if (r == 0) {
                r = p1.name.compareTo(p2.name);
            }
            return r;
        });

        // 이름 기준 정렬
        // {25, 김영희}, {20, 김철수}, {30, 홍길동}으로 정렬된다.
        Arrays.sort(people, (p1, p2) -> {
            int r = p1.name.compareTo(p2.name);
            if (r == 0) {
                r = p1.age - p2.age;
            }
            return r;
        });
    }
}