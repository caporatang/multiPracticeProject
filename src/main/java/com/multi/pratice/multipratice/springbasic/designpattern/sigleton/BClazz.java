package com.multi.pratice.multipratice.springbasic.designpattern.sigleton;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.sigleton
 * fileName : BClazz
 * author : taeil
 * date : 2023/02/16
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/16        taeil                   최초생성
 */
public class BClazz {
    private SocketClient socketClient;

    public BClazz() {
        this.socketClient = SocketClient.getInstance();
//        this.socketClient = new SocketClient();
    }
    public SocketClient getSocketClient() {
        return this.socketClient;
    }

}