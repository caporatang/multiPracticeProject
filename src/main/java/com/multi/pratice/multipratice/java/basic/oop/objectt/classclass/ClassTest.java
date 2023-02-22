package com.multi.pratice.multipratice.java.basic.oop.objectt.classclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.objectt.classclass
 * fileName : ClassTest
 * author : taeil
 * date : 2023/02/12
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/12        taeil                   최초생성
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        // java 11 버전에서는 테스트 불가함.
//        Class c1 = Class.forName("objectt.classclass");
//
//        Person person = (Person) c1.newInstance();
//
//        person.setName("KimTaeIl");
//        System.out.println(person);
//
//        Class c2 = person.getClass();
//        Person p = (Person) c2.newInstance();
//        System.out.println(p);



//        Class[] parameterTypes = {String.class};
//        Constructor cons =  c2.getConstructor(parameterTypes);
//
//        Object[] initargs = {"kim"};
//        Person kimPerson = (Person) cons.newInstance(initargs);
//        System.out.println(kimPerson);
        // 32번 라인부터는 Person kim2 = new Person("kim"); 과 같음
        // 이런 경우는 local에 Person 클래스가 존재하지 않는 경우에 사용하는 코딩방법임..





    }
}