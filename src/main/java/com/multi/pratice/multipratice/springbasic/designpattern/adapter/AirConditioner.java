package com.multi.pratice.multipratice.springbasic.designpattern.adapter;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.adapter
 * fileName : AirConditioner
 * author : taeil
 * date : 2023/02/17
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/17        taeil                   최초생성
 */
public class AirConditioner implements Electronic220V {
    @Override
    public void connect() {
        System.out.println("에어컨 220v on");
    }
}