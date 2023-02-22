package com.multi.pratice.multipratice.java.basic.oop.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.generic.wildcard
 * fileName : DrinkTest
 * author : taeil
 * date : 2023/02/15
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/15        taeil                   최초생성
 */
public class DietTest {
    public static void main(String[] args) {
        // 다이어트를 상속받은 클래스들을 접근할수있게해줌 ! --> 하위클래스 타입 접근 가능
        ArrayList<? extends Diet> sweetPotatoes = new ArrayList<SweetPotato>();
        ArrayList<? extends Diet> proteins = new ArrayList<Protein>();
        ArrayList<? extends Diet> diet = new ArrayList<Diet>();

        // 다이어트 상위클래스들의 타입으로 접근 가능
        ArrayList<? super Diet> superHeavy = new ArrayList<Object>();
        ArrayList<? super Diet> superHeavy2 = new ArrayList<Heavy>();
        ArrayList<? super Diet> superHeavy3 = new ArrayList<Diet>();


    }
}