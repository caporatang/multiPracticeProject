package com.multi.pratice.multipratice.java.basic.oop.accessModifier;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.AccessModifier
 * fileName : BirthDay
 * author : taeil
 * date : 2023/01/17
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/17        taeil                   최초생성
 */
public class BirthDay {
    // 정보 은닉
    // private을 붙이지 않는 경우 객체의 역할이나 맴버변수의 오용, 오류를 막아줄수있음(외부에서 직접 맴버변수를 조작하지 못하게 해줌)
    // 그래서 맴버 변수, 속성은 private을 붙이고 메서드로 제어를 하는것.

    private int day;
    private int month;
    private int year;

    private boolean isValid;

    public void getDay(int day) {
        //this 키워드로 맴버변수를 지정
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month < 1 || month > 12)
        {
            isValid = false;
        }
        else {
            isValid = true;
            this.month = month;
        }
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void showDate()
    {
        if(isValid) {
            System.out.println(year + "년" + month + "월" + day + "입니다");
        } else {
            System.out.println("유효하지 않은 날짜");
        }
    }


}