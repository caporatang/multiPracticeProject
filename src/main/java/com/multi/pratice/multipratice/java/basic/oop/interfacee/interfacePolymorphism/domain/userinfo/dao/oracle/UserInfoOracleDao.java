package com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.dao.oracle;

import com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.UserInfo;
import com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.dao.UserInfoDao;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.dao.oracle
 * fileName : UserInfoOracleDao
 * author : taeil
 * date : 2023/02/06
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/06        taeil                   최초생성
 */
public class UserInfoOracleDao implements UserInfoDao {
    @Override
    public void insertUserInfo(UserInfo userInfo) {
        System.out.println("Insert into Oracle DB userId = " + userInfo.getUserId());
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("Update set Oracle DB userId = " + userInfo.getUserId());
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        System.out.println("Delete from Oracle DB userId = " + userInfo.getUserId());
    }
}