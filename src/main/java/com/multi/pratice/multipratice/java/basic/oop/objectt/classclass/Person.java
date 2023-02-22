package com.multi.pratice.multipratice.java.basic.oop.objectt.classclass;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.objectt.classclass
 * fileName : Person
 * author : taeil
 * date : 2023/02/12
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/12        taeil                   최초생성
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return name;
    }
}