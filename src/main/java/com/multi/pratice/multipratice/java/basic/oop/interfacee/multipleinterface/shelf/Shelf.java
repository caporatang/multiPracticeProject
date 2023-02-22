package com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface.shelf;

import java.util.ArrayList;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee.multipleinterface
 * fileName : Shelf
 * author : taeil
 * date : 2023/02/08
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/08        taeil                   최초생성
 */
public class Shelf {
    // implements, extends 동시 사용..

    protected ArrayList<String> shelf;

    public Shelf() {
        // 맴버변수 초기화
        shelf = new ArrayList<String>();
    }

    public ArrayList<String> getShelf() {
        return shelf;
    }

    public int getCount() {
        return shelf.size();
    }


}