package com.multi.pratice.multipratice.java.basic.oop.compareto.exampleCode;

import java.util.Arrays;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.compareto
 * fileName : Example
 * author : taeil
 * date : 2023/06/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/06/28        taeil                   최초생성
 */
public class Example {

    public static void main(String[] args) {
        // 정렬 실패
        // java.lang.ClassCastException -> Person class 는 Comparable 인터페이스를 구현하지 않았기 때문에 sort로 정렬할수없음
        Person[] people = {new Person(30, "홍길동"), new Person(20, "김철수"), new Person(25, "김영희")};
        Arrays.sort(people);
    }
}
class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}