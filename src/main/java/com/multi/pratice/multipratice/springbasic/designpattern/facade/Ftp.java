package com.multi.pratice.multipratice.springbasic.designpattern.facade;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.facade
 * fileName : FTP
 * author : taeil
 * date : 2023/02/20
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/20        taeil                   최초생성
 */
public class Ftp {
    private String host;
    private int port;
    private String path;

    public Ftp(String host, int port, String path) {
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public void connect() {
        System.out.println("FTP Host : " + host + " Port : " + port + "로 연결합니다");
    }

    public void moveDirectory () {
        System.out.println("path : " + path + "로 이동합니다");
    }

    public void disConnect() {
        System.out.println("FTP 연결 종료");
    }



}