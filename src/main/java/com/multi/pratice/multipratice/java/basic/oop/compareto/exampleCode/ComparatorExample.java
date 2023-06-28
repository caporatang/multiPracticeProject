package com.multi.pratice.multipratice.java.basic.oop.compareto.exampleCode;

import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;

/**
* packageName : com.multi.pratice.multipratice.java.basic.oop.compareto.exampleCode
* fileName : ComparatorExample
* author : taeil
* date : 2023/06/28
* description :
* =======================================================
* DATE          AUTHOR                      NOTE
* -------------------------------------------------------
* 2023/06/28        taeil                   최초생성
*/
public class ComparatorExample {
    public static void main(String[] args) {
        Human[] humans = {new Human(30, "홍길동"), new Human(10, "김태일"), new Human(26, "김김규")};
        Arrays.sort(humans, new HumanAgeComparator());
        System.out.println("humans Age = " + Arrays.toString(humans));
        Arrays.sort(humans, new HumanNameComparator());
        System.out.println("humans Name= " + Arrays.toString(humans));
    }
}

@ToString
class Human {
    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }
}


class HumanAgeComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        int r = o1.age - o2.age;
        if (r == 0) {
            r = o1.name.compareTo(o2.name);
        }
        return r;
    }
}

class HumanNameComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        int r = o1.name.compareTo(o2.name);
        if (r == 0) {
            r = o1.age - o2.age;
        }
        return r;
    }
}