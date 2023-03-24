package com.multi.pratice.multipratice.java.basic.oop.stream.reduce;

import java.util.Arrays;
import java.util.function.BinaryOperator;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.stream.reduce
 * fileName : ReduceTest
 * author : taeil
 * date : 2023/03/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/24        taeil                   최초생성
 */

class CompareString implements BinaryOperator<String> {
    // --> 개발자가 따로 구현할수있음
    @Override
    public String apply(String s1, String s2) {
        // 아래에서 정의한 reduce와 동일한 결과
        if(s1.getBytes().length >= s2.getBytes().length ) return s1;
        else return s2;
    }
}


public class ReduceTest {
    public static void main(String[] args) {
        String[] greetings ={"안녕하셈", "hello@@", "Good morning@", "ㅎㅇㅎㅇ^^~~"};

        // 배열에서 가장 긴 length를 가진 문자열 찾아오기
        System.out.println(Arrays.stream(greetings).reduce("",(s1, s2) ->
            {
                if(s1.getBytes().length >= s2.getBytes().length ) return s1;
                    else return s2;
            }
            )
        );

        // 위에서 정의한 클래스(BinaryOperator)를 사용해서 결과값 출력
        String str = Arrays.stream(greetings).reduce(new CompareString()).get();
        System.out.println(str);
    }
}