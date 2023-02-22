package com.multi.pratice.multipratice.java.basic.oop.statickeyword.singletonpattern;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.statickeyword.singletonpattern
 * fileName : Company
 * author : taeil
 * date : 2023/01/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/18        taeil                   최초생성
 */
public class Company {

    // 만들어준 유일한 객체 --> 외부에서 사용할수있게 만들어주어야함
    private static Company instance = new Company();

    public static Company getInstance() {
        // 인스턴스 반환 메서드
        if(instance == null) {
            instance = new Company();
        }
        return instance;
    }


    private Company() {
        // 외부에서 컴퍼니 인스턴스를 여러개 만들수없도록 private로 생성자를 제공함 --> 따로 지정하는 이유 : private로 하지 않으면 default생성자가 생성 --> public
    }




}