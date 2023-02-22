package com.multi.pratice.multipratice.java.basic.oop.statickeyword.singletonpattern;

import java.util.Calendar;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.statickeyword.singletonpattern
 * fileName : CompanyTest
 * author : taeil
 * date : 2023/01/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/18        taeil                   최초생성
 */
public class CompanyTest {


    public static void main(String[] args) {
        // 스태틱인 경우 인스턴스 자체를 가져다가 써야함
        Company company1 = Company.getInstance();
        Company company2 = Company.getInstance();
        System.out.println(company1);
        System.out.println(company2);

        // 유일한 객체를 가져다 쓰는 경우..
        Calendar calendar = Calendar.getInstance();



    }


}