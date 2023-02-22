package com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.dao;

import com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.UserInfo;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.dao
 * fileName : UserInfoDao
 * author : taeil
 * date : 2023/02/06
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/06        taeil                   최초생성
 */
public interface UserInfoDao {
    // 인터페이스는 쉽게 생각하면 .. 클래스에 대한 명세서..
    void insertUserInfo(UserInfo userInfo);
    void updateUserInfo(UserInfo userInfo);
    void deleteUserInfo(UserInfo userInfo);
}