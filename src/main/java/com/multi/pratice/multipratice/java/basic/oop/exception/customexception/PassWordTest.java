package com.multi.pratice.multipratice.java.basic.oop.exception.customexception;

import lombok.Getter;
import lombok.Setter;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.exception.customexception
 * fileName : PassWordTest
 * author : taeil
 * date : 2023/03/25
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/25        taeil                   최초생성
 */
public class PassWordTest {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws PasswordException{
        if(password == null) {
            throw new PasswordException("비밀번호는 null일 수 없습니다.");
        }
        else if(password.length() < 5) {
            throw new PasswordException("비밀번호는 5자 이상이여야 합니다.");
        }
        else if(password.matches("[a-zA-Z]+")) {
            throw new PasswordException("비밀번호는 숫자나 특수문자를 포함해야 합니다.");
        }
        this.password = password;
    }

    public static void main(String[] args) {
        PassWordTest test = new PassWordTest();

        String password = null;
        try {
            test.setPassword(password);
            System.out.println("에러 없음1");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        password = "abc";
        try {
            test.setPassword(password);
            System.out.println("에러 없음2");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        password = "abcde";
        try {
            test.setPassword(password);
            System.out.println("에러 없음3");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        password = "abcde1#";
        try {
            test.setPassword(password);
            System.out.println("에러 없음4");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }
    } // main
} // class