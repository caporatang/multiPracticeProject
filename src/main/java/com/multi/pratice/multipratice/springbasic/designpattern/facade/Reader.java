package com.multi.pratice.multipratice.springbasic.designpattern.facade;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.facade
 * fileName : Reader
 * author : taeil
 * date : 2023/02/20
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/20        taeil                   최초생성
 */
public class Reader {
    private String fileName;
    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String msg = String.format("Reader %s 로 연결 합니다", fileName);
        System.out.println(msg);
    }

    public void fileRead() {
        String msg = String.format("Reader %s 에 내용을 읽어 옵니다", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect() {
        String msg = String.format("Reader %s 로 연결 종료 합니다", fileName);
        System.out.println(msg);
    }
}