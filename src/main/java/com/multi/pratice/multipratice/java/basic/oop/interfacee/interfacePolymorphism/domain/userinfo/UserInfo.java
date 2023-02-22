package com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo
 * fileName : UserInfo
 * author : taeil
 * date : 2023/02/06
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/06        taeil                   최초생성
 */
public class UserInfo {
    // db를 가져다가 쓴다는 가정하에 인터페이스 다형성을 활용하여 dao를 만들어보자

    private String userId;
    private String password;
    private String userName;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}