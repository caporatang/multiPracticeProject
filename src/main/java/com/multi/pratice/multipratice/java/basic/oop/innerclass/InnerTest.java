package com.multi.pratice.multipratice.java.basic.oop.innerclass;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.innerclass
 * fileName : InnerTest
 * author : taeil
 * date : 2023/02/13
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/13        taeil                   최초생성
 */

class OutClass {
    private int num = 10;
    private static int sNum = 20;

    // out클래스에 이너클래스를 선언함
    private InClass inClass;
    public OutClass() {
        inClass = new InClass();
    }

    // 이너 클래스를 private으로 선언하는것이 권장된다.
    // private이 아닌 경우에 외부 클래스에서 이너 클래스 객체를 생성 가능하기 때문이다.
    private class InClass{
        int iNum = 100;

        // 인스턴스 이너 클래스는 outerClass가 먼저 생성되고 생성되기 때문에 이너 클래스에서 바로 스태틱변수는 선언할수없음
        // static int sInNum = 500;

        void inTest() {
            System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + iNum + "(내부 클래스의 인스턴스 변수)");
        }
    }
    public void usingClass() {
        inClass.inTest();
    }

    static class InStaticClass {
        int iNum = 100;
        static int sInNum = 200;

        void inTest() {
            // 외부 클래스 생성과 상관없이 만들수가 있기 떄문에, 외부 클래스에 인스턴스 변수는 사용할 수 없음
            // System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("InClass num = " + iNum + "(내부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + sInNum + "(내부 클래스의 스태틱 변수)");
        }

        static void sTest() {
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + sInNum + "(내부 클래스의 스태틱 변수)");
        }
    }
}

public class InnerTest {

    public static void main(String[] args) {
        // --> 외부 클래스에서 사용해보자


        // 익명 클래스를 사용해보자
        // OutClass outClass = new OutClass();
        // outClass.usingClass();

        // static 클래스를 사용해보자
        OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
        sInClass.inTest(); // --> 일반 메서드

        System.out.println();

        //static method 바로 호출
        OutClass.InStaticClass.sTest();
    }


}