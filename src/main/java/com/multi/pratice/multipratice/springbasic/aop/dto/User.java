package com.multi.pratice.multipratice.springbasic.aop.dto;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.aop.dto
 * fileName : User
 * author : taeil
 * date : 2023/02/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/24        taeil                   최초생성
 */
public class User {
    private String id;
    private String pw;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", eamil='" + email + '\'' +
                '}';
    }
}