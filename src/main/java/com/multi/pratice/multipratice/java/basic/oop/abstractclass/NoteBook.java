package com.multi.pratice.multipratice.java.basic.oop.abstractclass;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.abstractclass
 * fileName : NoteBook
 * author : taeil
 * date : 2023/02/01
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/01        taeil                   최초생성
 */
public abstract class NoteBook extends Computer {
    // 추상클래스를 하나라도 오버라이딩하지 않는다면 추상클래스가 되어야한다ㅏㅏ
    @Override
    public void display() {
        System.out.println("NoteBook display");
    }



}