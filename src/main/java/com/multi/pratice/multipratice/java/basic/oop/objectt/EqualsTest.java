package com.multi.pratice.multipratice.java.basic.oop.objectt;

import java.sql.SQLOutput;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.objectt
 * fileName : EqualsTest
 * author : taeil
 * date : 2023/02/10
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/10        taeil                   최초생성
 */
public class EqualsTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student std1 = new Student(100 ,"Kim");
        Student std2 = new Student(100 ,"Kim");

        System.out.println(std1 == std2);
        System.out.println(std1.equals(std2));

        System.out.println(std1.hashCode());
        System.out.println(std2.hashCode());

        // 해시코드를 오버라이드해서 학번(studentNum)으로 리턴했을때 hash값을 찾을수있게 해주는 메서드
        System.out.println(System.identityHashCode(std1));
        System.out.println(System.identityHashCode(std2));

        // clone
        std1.setStudentName("kim");
        Student copyStudent = (Student) std1.clone();
        System.out.println(copyStudent);

    }


}