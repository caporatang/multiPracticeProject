package com.multi.pratice.multipratice.java.basic.oop.innerclass;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.innerclass
 * fileName : AnonumousInnerTest
 * author : taeil
 * date : 2023/02/13
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/13        taeil                   최초생성
 */

class Outer2 {
    int outNum = 100;
    static int sNum = 200;

    // class를 스레드화 할때 사용하는 메서드
    // 지역변수와 매개변수는 메서드가 호출될때 stack 메모리에 생성이 된다.
    Runnable getRunnable(int i) {
        // 지역변수 (local변수)
        int num = 10;

        class MyRunnable implements Runnable{
            // local inner class
            // 맴버변수
            int localNum = 1000;

            @Override
            public void run() {
                // 위에서 선언한 i 와 num의 값을 메서드 안에서 바꿀려고 하면 에러가 발생된다.
                // -> 위에 적어놨듯이 i 와 num은 stack메모리에 생성이 된다
                // -> stack메모리에 생성이 되기 때문에 메서드가 호출되면 메모리상에서 없어진다.
                // -> 메서드는 다시 호출될 여지가 있기 떄문에 값을 바꾸지 못하고 final로 선언되는것이다.

                // final로 직접적으로 선언을 하지 않아도 컴파일러가 final로 컴파일해서 처리한다.
                // 메서드 호출이 끝난다고 해도 stack메모리처럼 사라지는게 아니라 final로 처리를 하기 때문에
                // 상수화되어 상수메모리(constant area)에 메모리가 잡히게 된다.. 개념이 어렵다...

                System.out.println("i = " + i);
                System.out.println("num = " + num);
                System.out.println("localNum = " + localNum);

                System.out.println("outNum = " + outNum +" (외부 클래스 인스턴스 변수)");
                System.out.println("Ouuter.sNum = " + Outer2.sNum + " (외부 클래스 정적 변수");

            }
        }
        return new MyRunnable();
    }// getRunnable end

    Runnable getRunnable2(int i) {
            // 지역변수 (local변수)
            int num = 10;

            // 로컬 이너 클래스와 다르게, 어차피 클래스 이름을 호출하는곳이
            // 같은 클래스에서밖에 없으므로, 그냥 바로 Runnable객체를 리턴 -> 이게 어나니머스 이너 클래스이다
            // 지역 이너클래스와 동일하게 매개변수와 지역변수는 값을 바꿀수없다.
            return new Runnable() {
                int localNum = 1000;
                @Override
                public void run() {
                    System.out.println("i = " + i);
                    System.out.println("num = " + num);
                    System.out.println("localNum = " + localNum);

                    System.out.println("outNum = " + outNum + " (외부 클래스 인스턴스 변수)");
                    System.out.println("Ouuter.sNum = " + Outer2.sNum + " (외부 클래스 정적 변수");

                }
            };
    }

    // 어나니머스 이너 클래스 사용방법 2
    Runnable runnable = new Runnable() {
        // 객체 생성과 동시에 오버라이딩
        @Override
        public void run() {
            System.out.println("Runnable class");
        }
    };

}

public class AnonumousInnerTest {
    public static void main(String[] args) {
        // 지역 내부 클래스를 사용해보자
        Outer2 out = new Outer2();
        Runnable runner = out.getRunnable(100);
        runner.run();

        // 어나니머스 이너클래스 사용방법 2
        out.runnable.run();
    }
}