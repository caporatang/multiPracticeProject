package com.multi.pratice.multipratice.java.basic.oop.lambda.comparison;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.lambda.comparison
 * fileName : StringConcatTest
 * author : taeil
 * date : 2023/03/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/23        taeil                   최초생성
 */
public class StringConcatTest {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "world~";

        // 객체지향 방식..!
        StringConcatImpl stringConcat = new StringConcatImpl();
        stringConcat.makeString(s1, s2);

        // 람다 --> StringConcatImpl 클래스를 만들지 않았다. --> 근데 왜 실행이 되냐?
        StringConcat lambdaConcat = (s, v) -> System.out.println(s + "," + v);
        lambdaConcat.makeString(s1, s2);
        // 내부적으로 익명 클래스가 만들어진것.. --> 그래서 FunctionalInterface 사용시, 내부에 메서드를 하나만 만드는것.
        StringConcat lambdaConcat2 = new StringConcat() {
            @Override
            public void makeString(String s1, String s2) {
                System.out.println(s1 + "...." + s2);
            }
        };
        lambdaConcat2.makeString(s1, s2);
    }
}