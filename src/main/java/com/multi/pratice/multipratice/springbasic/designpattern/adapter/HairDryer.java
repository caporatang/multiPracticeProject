package com.multi.pratice.multipratice.springbasic.designpattern.adapter;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.adapter
 * fileName : HairDryer
 * author : taeil
 * date : 2023/02/17
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/17        taeil                   최초생성
 */
public class HairDryer implements Electronic110V {
    @Override
    public void powerOn() {
        System.out.println("헤어 드라이기 110v on");
    }
}