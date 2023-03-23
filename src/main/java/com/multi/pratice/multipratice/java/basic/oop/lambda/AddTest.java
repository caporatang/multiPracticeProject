package com.multi.pratice.multipratice.java.basic.oop.lambda;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.lambda
 * fileName : AddTest
 * author : taeil
 * date : 2023/03/22
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/22        taeil                   최초생성
 */
public class AddTest {

    public static void main(String[] args) {

        // 람다를 사용해서 인터페이스에서 정의한 add를 구현
        //  Add addL = (x, y) -> {return x + y;};
        Add addL = (x, y) -> x+y;
        System.out.println(addL.add(2,3));

    }
}