package com.multi.pratice.multipratice.java.basic.oop.lambda.functionalinterface;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.lambda.functionalinterface
 * fileName : MyNumberTest
 * author : taeil
 * date : 2023/03/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/23        taeil                   최초생성
 */
public class MyNumberTest {
    public static void main(String[] args) {
        MyNumber myNumber = (x, y) -> x > y ? x : y;
        System.out.println(myNumber.getMax(10, 20));
    }

}