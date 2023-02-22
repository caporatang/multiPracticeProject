package com.multi.pratice.multipratice.java.basic.oop.objectt.stringclass;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.objectt.stringclass
 * fileName : StringBuilderTest
 * author : taeil
 * date : 2023/02/11
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/11        taeil                   최초생성
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        String java = new String("java");
        String android = new String("android");

        // String을 사용해서 문자열을 붙일때와 다르게 문자열을 이어 붙여도, 같은 주소값이 나온다.
        StringBuilder buffer = new StringBuilder(java);
        System.out.println(System.identityHashCode(buffer));

        buffer.append(android);
        System.out.println(System.identityHashCode(buffer));

        String test = buffer.toString();
        System.out.println(test);



    }
}