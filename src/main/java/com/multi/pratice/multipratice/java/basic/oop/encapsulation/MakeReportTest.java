package com.multi.pratice.multipratice.java.basic.oop.encapsulation;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.incapsulation
 * fileName : MakeReportTest
 * author : taeil
 * date : 2023/01/17
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/17        taeil                   최초생성
 */
public class MakeReportTest {

    public static void main(String[] args) {
        MakeReport builder = new MakeReport();
        String report = builder.getReport();
        System.out.println(report);
    }

}