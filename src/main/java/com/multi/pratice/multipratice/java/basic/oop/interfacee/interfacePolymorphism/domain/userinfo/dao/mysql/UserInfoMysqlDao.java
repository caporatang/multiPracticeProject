package com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.dao.mysql;

import com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.UserInfo;
import com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.dao.UserInfoDao;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.dao.mysql
 * fileName : UserInfoMysqlDao
 * author : taeil
 * date : 2023/02/06
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/06        taeil                   최초생성
 */
public class UserInfoMysqlDao implements UserInfoDao {
    @Override
    public void insertUserInfo(UserInfo userInfo) {
        System.out.println("Insert into MySQL DB userId = " + userInfo.getUserId());
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("Update set MySQL DB userId = " + userInfo.getUserId());
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        System.out.println("Delete from MySQL DB userId = " + userInfo.getUserId());
    }
}