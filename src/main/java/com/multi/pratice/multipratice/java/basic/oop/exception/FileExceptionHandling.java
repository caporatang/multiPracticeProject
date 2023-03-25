package com.multi.pratice.multipratice.java.basic.oop.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.exception
 * fileName : FileExceoptionHandling
 * author : taeil
 * date : 2023/03/25
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/25        taeil                   최초생성
 */
public class FileExceptionHandling {

    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("a.txt");
            System.out.println("read");

        } catch (FileNotFoundException e) {
            e.printStackTrace(); // -> 에러 위치 출력
            System.out.println(e);
            return;
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("finally");
        }
        System.out.println("end");
    }
}