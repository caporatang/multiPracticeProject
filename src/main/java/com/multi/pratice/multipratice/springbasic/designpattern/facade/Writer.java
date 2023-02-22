package com.multi.pratice.multipratice.springbasic.designpattern.facade;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.facade
 * fileName : Writer
 * author : taeil
 * date : 2023/02/20
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/20        taeil                   최초생성
 */
public class Writer {
    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String msg = String.format("Writer %s 로 연결함", fileName);
        System.out.println(msg);
    }

    public void fileDisConnect() {
        String msg = String.format("Writer %s 에 연결 종료", fileName);
        System.out.println(msg);
    }

    public void write() {
        String msg = String.format("Writer %s 로 파일 씀", fileName);
        System.out.println(msg);
    }

}