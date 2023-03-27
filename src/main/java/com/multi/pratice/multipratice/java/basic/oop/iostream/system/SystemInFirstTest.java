package com.multi.pratice.multipratice.java.basic.oop.iostream.system;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.iostream.system
 * fileName : SystemInFirstTest
 * author : taeil
 * date : 2023/03/27
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/27        taeil                   최초생성
 */
public class SystemInFirstTest {

    public static void main(String[] args) {

        System.out.println("알파벳 여러 개를 쓰고 [Enter]를 누르세요");

        int i;

        try {
            // 표준 입력 스트림을 사용해야 한글을 읽을수있음 --> InputStreamReader -> 보조스트림
            InputStreamReader irs = new InputStreamReader(System.in);

            // read는 하나의 바이트씩만 read --> 한글은 입력할수없음
            // while ((i = System.in.read()) != '\n') {
            while ((i = irs.read()) != '\n') {

                // System.out.println(i);
                System.out.print((char)i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}