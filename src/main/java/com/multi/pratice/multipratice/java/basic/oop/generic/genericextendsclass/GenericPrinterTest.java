package com.multi.pratice.multipratice.java.basic.oop.generic.genericextendsclass;

import com.multi.pratice.multipratice.java.basic.oop.generic.genericextendsclass.Powder;
import com.multi.pratice.multipratice.java.basic.oop.generic.genericextendsclass.GenericPrinter;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.generic.useGeneric
 * fileName : GenericPrinterTest
 * author : taeil
 * date : 2023/02/15
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/15        taeil                   최초생성
 */
public class GenericPrinterTest {

    public static void main(String[] args) {

        Powder powder = new Powder();

        // 만약 다이아몬드 연산자에 Powder를 지정하지 않는 경우 Object로 판단하고 에러가 출력된다.
        // 굳이 이렇게 쓸 필요는 없지만.. 알아두자
        GenericPrinter<Powder> powderGenericPrinter = new GenericPrinter<>();
        powderGenericPrinter.setMaterial(powder);

        // 컴파일 단계에서 컴파일러가 해당 타입으로 리플레이스를 해주기 때문에, 캐스팅없이 사용 가능한것임
        Powder p = powderGenericPrinter.getMaterial();
        System.out.println(powderGenericPrinter.toString());

        // 클래스가 있어도 ! 사용 불가
        // GenericPrinter<Water> water = new GenericPrinter<Water>();



    }
}