package com.multi.pratice.multipratice.java.basic.oop.virtualmethod;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.virtualmethod
 * fileName : VirtualMethod
 * author : taeil
 * date : 2023/01/19
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/19        taeil                   최초생성
 */
public class VirtualMethod {
    // 가상함수 -> method의 호출 방식
    // a라는 함수가 호출하게 되면 a안에 있는 명령어들이 메모리에 올라가게 되면, 크게 두가지 영역으로 나뉨, -> 코드 영역과 데이터영역(static영역, 상수영역)
    // 코드 영역에 프로그램에서 만든 메서드들이 할당된다.(기능)

    // 메서드(함수)의 이름은 곧 주소값을 나타낸다
    // 메서드는 명령어의 set이고 프로그램이 로드되면 메서드 영역(코드영역)에 명령어 set이 위치하게 된다
    // 해당 메서드가 호출 되면 명령어 set이 있는 주소를 찾아 명령어가 실행되게 된다
    // 이때, 메서드에서 사용하는 변수들은 스택 메모리에 위치하게 된다 --> 지역변수를 뜻함
    // 따라서 다른 인스턴스라도 같은 메서드의 코드는 같으므로 같은  메서드가 호출되게 된다
    // 인스턴스가 생성되면 변수는 힙 메모리에 따로 생성되지만, 메서드 명령어 set은 처음 한번만 로드 된다


    //    ex)
    //    public class testMethod() {
    //        int num;
    //        void aaa() {
    //            System.out.println("aaa() 호출");
    //        }
    //
    //        public static void main(String[] args) {
    //            TestMethod a1 = new testMethod();
    //            a1.aaa();
    //
    //            testMethod a2 = new testMethod();
    //            a2.aaa();
    //        }

    // 위 코드를 실행하는 경우에 메모리 구조는 다음과 같다

    //      힙            스택            메서드영역
    //     a1의 num       a1(인스턴스)       aaa() 메서드 영역
    //     a2의 num       a2(인스턴스)
    //                   args(main의 지역변수)


    // 가상 메서드의 원리
    // 가상 메서드 테이블에서 해당 메서드에 대한 address를 가지고 있음
    // 재정의 된 경우는 재정의 된 메서드의 주소를 가리킨다.
    // --> VIPCustomer에 재정의된 함수가 호출되게 되는경우에! 가상메서드 테이블로 가서. 재정의된 메서드의 주소가 바인딩되어 재정의된 메서드가 호출되게 되는것이다.














}