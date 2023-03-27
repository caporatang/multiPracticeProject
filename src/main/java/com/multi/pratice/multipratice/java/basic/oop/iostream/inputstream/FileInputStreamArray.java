package com.multi.pratice.multipratice.java.basic.oop.iostream.inputstream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.iostream.inputstream
 * fileName : FileInputSecondStream
 * author : taeil
 * date : 2023/03/27
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/27        taeil                   최초생성
 */
public class FileInputStreamArray {

    public static void main(String[] args) {

        int i;
        try (FileInputStream fis = new FileInputStream("input2.txt")) {

            byte[] bs = new byte[10];

            // 이때 i는 읽은 바이트의 수
            //while( (i = fis.read(bs)) != -1 ) {

            // 버퍼의 offset은 1부터, 9개까지 읽어와.
            while( (i = fis.read(bs, 1, 9)) != -1 ) {

                //for(int ch : bs) {
                for (int j = 0; j < i; j++) {
                    System.out.print( (char) bs[j]);
                }
                System.out.println(" : " + i + " 바이트 읽음");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}