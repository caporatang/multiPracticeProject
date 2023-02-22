package com.multi.pratice.multipratice.java.basic.oop.thiss;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.thiss
 * fileName : Person
 * author : taeil
 * date : 2023/01/17
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/17        taeil                   최초생성
 */
public class Person {
    String name;
    int age;

    public Person() {
        //이렇게 쓰는건 불가능하다. 먼저 다른 생성자를 호출한 다음에 가능하다
//        int num = 10;
//        name = "df";
        this("no name", 1);
        // 다른 생성자를 먼저 호출한 후 다른 스테이트먼트를 사용하는것은 가능하다
//        int num = 10;
//        name = "df";
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showPerson()
    {
        System.out.println(name + ", " + age);
    }

    public Person getPerson() {
        // 자기 자신을 리턴
        return this;
    }

    public static void main(String[] arge) {
        // default 생성자
        Person person = new Person();
        person.showPerson();
        System.out.println(person);

        //자기 자신을 리턴
        Person person2 = person.getPerson();
        System.out.println(person2);
    }


}



