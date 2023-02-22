package com.multi.pratice.multipratice.java.basic.oop.accessModifier;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.AccessModifier
 * fileName : BirthDayTest
 * author : taeil
 * date : 2023/01/17
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/17        taeil                   최초생성
 */
public class BirthDayTest {
    public static void main(String[] args) {
        BirthDay date = new BirthDay();
        date.setYear(2019);
        date.setMonth(12);
        date.setDay(30);

        date.showDate();

    }
}