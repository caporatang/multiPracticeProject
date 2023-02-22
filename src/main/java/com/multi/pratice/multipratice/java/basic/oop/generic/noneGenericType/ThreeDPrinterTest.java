package com.multi.pratice.multipratice.java.basic.oop.generic.noneGenericType;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.generic.noneGenericType
 * fileName : ThreeDPrinterTest
 * author : taeil
 * date : 2023/02/15
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/15        taeil                   최초생성
 */
public class ThreeDPrinterTest {

    public static void main(String[] args) {
        Powder powder = new Powder();
        ThreeDPrinter3 printer = new ThreeDPrinter3();
        printer.setMaterial(powder);
        // 오브젝트 타입으로 받는 경우 하나씩 캐스팅을 해주어야 하기 떄문에 불편..
        // 이러한 문제점을 해결하기 위해 제네릭이 나옴
        Powder p = (Powder) printer.getMaterial();

    }

}