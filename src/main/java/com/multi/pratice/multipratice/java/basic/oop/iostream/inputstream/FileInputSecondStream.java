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
public class FileInputSecondStream {

    public static void main(String[] args) {

        int i;
        try (FileInputStream fis = new FileInputStream("input.txt")) {
            while ( (i = fis.read()) != -1 ) {
                System.out.print( (char) i );
            }
        } catch (IOException e) {
            System.out.println(e);
        }


    }

}