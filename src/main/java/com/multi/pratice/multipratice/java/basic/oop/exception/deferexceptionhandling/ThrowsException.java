package com.multi.pratice.multipratice.java.basic.oop.exception.deferexceptionhandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.exception.deferexceptionhandling
 * fileName : ThrowsException
 * author : taeil
 * date : 2023/03/25
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/25        taeil                   최초생성
 */
public class ThrowsException {

    public Class loadClass(String fileName, String className) throws ClassNotFoundException, FileNotFoundException {
        // 에러 발생용
        FileInputStream fis = new FileInputStream(fileName);

        Class c = Class.forName(className);
        return c;
    }

    public static void main(String[] args) {

        ThrowsException test = new ThrowsException();

        try {
            test.loadClass("a.txt", "abc");
            // test.loadClass("a.txt", "java.lang.String");

        // } catch (ClassNotFoundException e ) {
        } catch (ClassNotFoundException e ) {
            System.out.println(e);

        } catch (FileNotFoundException e) {
            System.out.println(e);

        } catch (Exception e) {
            // default exception
            System.out.println("나는 최상위 익셉션..~");
        }
        System.out.println("end");
    }

}