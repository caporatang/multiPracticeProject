package com.multi.pratice.multipratice.java.basic.oop.objectt.classclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.objectt.classclass
 * fileName : StringTest
 * author : taeil
 * date : 2023/02/12
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/12        taeil                   최초생성
 */
public class StringTest {
    public static void main(String[] args) throws ClassNotFoundException {

        // 대소문자 구분 등, class를 로드 할 수있게 해야한다. fullname으로 입력..!
        Class c = Class.forName("java.lang.String");

        // java.lang.reflect에 위치 되어있음.
        Constructor[] cons =  c.getConstructors();

        // 가지고 온 클래스들의 생성자들을 출력해보자
        for (Constructor co : cons) {
            System.out.println(co);
        }

        //가지고 온 클래스의 맴버 메서드들을 출력해보자
        Method[] m = c.getMethods();
        for (Method mth : m) {
            System.out.println(mth);
        }
        // 실직적으로 잘 사용하지 않지만 로컬에 파일이 없거나 하는 경우에 이런식으로 사용할수있음





    }
}