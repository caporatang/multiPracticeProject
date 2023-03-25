package com.multi.pratice.multipratice.java.basic.oop.exception.autocloseable;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.exception.autocloseable
 * fileName : AutoCloseTest
 * author : taeil
 * date : 2023/03/25
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/25        taeil                   최초생성
 */
public class AutoCloseTest {
    public static void main(String[] args) {
        // 에러가 발생되면 ..!
        // 제일 먼저 Autoclose가 되고 ("closing..!")
        // catch에 "exception"이 호출
        // 그 후에 catch문을 빠져나간 후 end가 호출

        AutoCloseableObj obj = new AutoCloseableObj();
        try(obj) {
            // autoclose는 항상 실행되는거기 때문에, close가 잘 불리는지 확인
            throw new Exception();

        } catch (Exception e) {
            System.out.println("exception");
        }
        System.out.println("end");
    }


}