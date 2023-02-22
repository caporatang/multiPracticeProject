package com.multi.pratice.multipratice.springbasic.designpattern.adapter;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.adapter
 * fileName : SocketAdapter
 * author : taeil
 * date : 2023/02/17
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/17        taeil                   최초생성
 */
public class SocketAdapter implements Electronic110V {

    private Electronic220V electronic220V;

    // 기본 생성자에 220v 짜리 객체를 가지고있음
    public SocketAdapter(Electronic220V electronic220V) {
        this.electronic220V = electronic220V;
    }

    // 파워온일때 가지고온 220v짜리를 사용해서 connect
    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}