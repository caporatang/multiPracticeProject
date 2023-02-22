package com.multi.pratice.multipratice.springbasic.designpattern.sigleton;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.sigleton
 * fileName : AClazz
 * author : taeil
 * date : 2023/02/16
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/16        taeil                   최초생성
 */
public class AClazz {
    private SocketClient socketClient;

    public AClazz() {
        this.socketClient = SocketClient.getInstance();
//        this.socketClient = new SocketClient();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }


}