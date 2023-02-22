package com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.web;

import com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.UserInfo;
import com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.dao.UserInfoDao;
import com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.dao.mysql.UserInfoMysqlDao;
import com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.domain.userinfo.dao.oracle.UserInfoOracleDao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.interfacee.interfacePolymorphism.web
 * fileName : UserInfoClient
 * author : taeil
 * date : 2023/02/06
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/06        taeil                   최초생성
 */
public class UserInfoClient {

    public static void main(String[] args) throws IOException {
        // 인풋스트림을 활용하여 파일을 열고
        FileInputStream fis = new FileInputStream("db.properties");

        // properties는 key value로 이루어져있다.
        Properties prop = new Properties();
        prop.load(fis);
        String dbType = prop.getProperty("DBTYPE"); // DBTYPE에 해당하는 밸류를 가지고오자

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("나는 아이디");
        userInfo.setPassword("나는 비밀번호");
        userInfo.setUserName("나는 김태일");

        UserInfoDao userInfoDao = null;
        if(dbType.equals("ORACLE")) {
            userInfoDao = new UserInfoOracleDao();
        }
        else if(dbType.equals("MYSQL")) {
            userInfoDao = new UserInfoMysqlDao();
        } else {
            System.out.println("db error");
            return;
        }
        userInfoDao.insertUserInfo(userInfo);
        userInfoDao.updateUserInfo(userInfo);
        userInfoDao.deleteUserInfo(userInfo);

    }
}