package com.multi.pratice.multipratice.springbasic.designpattern.adapter;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.adapter
 * fileName : Cleaner
 * author : taeil
 * date : 2023/02/17
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/17        taeil                   최초생성
 */
public class Cleaner implements Electronic220V{

    @Override
    public void connect() {
        System.out.println("청소기 220v on");
    }

}