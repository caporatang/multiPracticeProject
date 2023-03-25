package com.multi.pratice.multipratice.java.basic.oop.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.exception
 * fileName : TryWithResources
 * author : taeil
 * date : 2023/03/25
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/25        taeil                   최초생성
 */
public class TryWithResources {
    // try-with-resources
    // 리소스를 사용하는 경우 close() 하지 않아도 자동으로 해제 되도록 함
    // 자바 7부터 제공되는 구문
    // 리소스를 try() 내부에서 선언해야만 함
    // close()를 명시적으로 호출되지 않아도 try() 블록에서 열린 리소스는 정상적인 경우나 예외가 발생한 경우 모두 자동으로 해제된다.
    // 해당 리소스 클래스가 AutoCloseable 인터페이스를 구현 해야 함
    // FileInputStream의 경우에는 AutoCloseable을 구현하고 있음
    // 자바 9부터는 리소스는 try() 외부에서 선언하고 변수만을 try(obj)와 같이 사용할 수 있음

    public static void main(String[] args) {

        try(FileInputStream fis = new FileInputStream("a.txt")) {
            System.out.println("read");
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}