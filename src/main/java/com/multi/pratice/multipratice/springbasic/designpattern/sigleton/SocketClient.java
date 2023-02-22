package com.multi.pratice.multipratice.springbasic.designpattern.sigleton;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.sigleton
 * fileName : SocketClient
 * author : taeil
 * date : 2023/02/16
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/16        taeil                   최초생성
 */
public class SocketClient {
    // 싱글톤은 자기 자신을 객체로 가지고 있어야함
    private static SocketClient socketClient = null;

    // 객체를 싱글톤으로 만들때는 기본생성자를 private으로 접근을 막음
    // -> 객체 생성을 하지 못하게 하기 위함임
     private SocketClient() { }

    // 싱글톤이 아닌 객체 테스트
//    public SocketClient() {}

    public static SocketClient getInstance() {
        if(socketClient == null) {
           socketClient = new SocketClient();
        }
        return socketClient;
    }
    public void connect() {
        System.out.println("connect");
    }
}