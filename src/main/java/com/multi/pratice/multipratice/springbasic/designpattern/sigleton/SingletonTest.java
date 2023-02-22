package com.multi.pratice.multipratice.springbasic.designpattern.sigleton;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.sigleton
 * fileName : SingletoneTest
 * author : taeil
 * date : 2023/02/16
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/16        taeil                   최초생성
 */
public class SingletonTest {
    public static void main(String[] args) {
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        // SocketClient의 기본 생성자를 private로 막고 테스트
        //  System.out.println("두개의 객체는 동일한가?");
        //  System.out.println(aClient.equals(bClient)); -> true

          System.out.println("두개의 객체는 동일한가?");
          System.out.println(aClient.equals(bClient));

    }

}