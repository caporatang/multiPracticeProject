package com.multi.pratice.multipratice.java.basic.oop.objectt.stringclass;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.objectt.stringclass
 * fileName : StringTest
 * author : taeil
 * date : 2023/02/11
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/11        taeil                   최초생성
 */
public class StringTest {
    public static void main(String[] args) {

        String java = new String("java"); // --> 힙에 java 인스턴스 생성
        String android = new String("android"); // 힙에 android 인스턴스 생성

        System.out.println(System.identityHashCode(java));

        //--> java에 붙이는 경우 javaandroid가 생성되긴하나, 위에 선언한 java가 없어지는것이 아니라 java가 가르키는 메모리가 새로운 문자열로 변경됨
        // -> java라는 인스턴스는 계속 남아있는 상태가 되서 메모리 낭비가 발생되는것임.
        java = java.concat(android);

        // java에 새로 어사인 했을때, 위에서 찍은 java와 다른 주소값을 가지고 있는것을 알수있음
        System.out.println(System.identityHashCode(java));

    }


}