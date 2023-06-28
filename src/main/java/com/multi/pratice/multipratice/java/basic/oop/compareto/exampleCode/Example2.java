package com.multi.pratice.multipratice.java.basic.oop.compareto.exampleCode;

import lombok.ToString;

import java.util.Arrays;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.compareto.exampleCode
 * fileName : Example2
 * author : taeil
 * date : 2023/06/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/06/28        taeil                   최초생성
 */
public class Example2 {
    public static void main(String[] args) {
        Person[] people = {new Person(30, "홍길동"), new Person(20, "김철수"), new Person(25, "김영희")};
        // 나이 순 정렬 성공 {20, 김철수}, {25, 김영희}, {30, 홍길동}으로 정렬된다.
        Arrays.sort(people);
        for (Person person : people) {
            System.out.println("person = " + person);
        }
    }

    @ToString
    static class Person implements Comparable<Person> {
        // Comparable 의 CompareTo를 오버라이딩 했기 때문에 sort로 정렬이 가능하다.
        int age;
        String name;


        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        /*
         * 나이를 기준으로 정렬하고 나이가 같다면 이름 순으로 정렬한다.
         */
        @Override
        public int compareTo(Person other) {
            int r = this.age - other.age;
            if (r == 0) {
                r = this.name.compareTo(other.name);
            }
            return r;
        }
    }
}