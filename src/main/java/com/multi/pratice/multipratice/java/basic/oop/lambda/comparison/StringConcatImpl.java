package com.multi.pratice.multipratice.java.basic.oop.lambda.comparison;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.lambda.comparison
 * fileName : StringConcatImpl
 * author : taeil
 * date : 2023/03/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/23        taeil                   최초생성
 */
public class StringConcatImpl implements StringConcat{

    @Override
    public void makeString(String s1, String s2) {
        System.out.println(s1 + "," + s2);
    }
}