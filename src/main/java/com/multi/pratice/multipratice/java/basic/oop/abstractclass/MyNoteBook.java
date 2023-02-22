package com.multi.pratice.multipratice.java.basic.oop.abstractclass;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.abstractclass
 * fileName : MyNoteBook
 * author : taeil
 * date : 2023/02/01
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/01        taeil                   최초생성
 */
public class MyNoteBook extends NoteBook{
    // 상위 객체에서 재정의하지 않은 추상메서드를 하위에서 재정의
    @Override
    public void typing() {
        System.out.println("MyNoteBook typing");
    }
}