package com.multi.pratice.multipratice.java.basic.oop.iostream.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.iostream.inputstream
 * fileName : FileInputFirstStream
 * author : taeil
 * date : 2023/03/27
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/27        taeil                   최초생성
 */
public class FileInputFirstStream {

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream fis = null;

        try {
            fis = new FileInputStream("input.txt");
            // file 에서 마지막 으로 읽은 데이터 가 없을때 -1을 반환
            System.out.println((char)fis.read());
            System.out.println((char)fis.read());
            System.out.println((char)fis.read());

        } catch (IOException e) {
            e.printStackTrace();
            // try {
            //    fis.close();
            //} catch (IOException e1) {
            //    e1.printStackTrace();
            //} catch (Exception e2) {
            //    System.out.println(e2);
            //}

        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                System.out.println(e2);
            }
        }
        System.out.println("end");
    }
}