package com.multi.pratice.multipratice.java.basic.oop.extendss.extendscast;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.extendss.extendscast
 * fileName : Extends
 * author : taeil
 * date : 2023/01/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/18        taeil                   최초생성
 */
public class Extends {

    // 상속에서 클래스 생성 과정과 형 변환
    // 하위 클래스가 생성 되는 과정
    // 1. 하위 클래스를 생성하면 상위 클래스가 먼저 생성 됨
    // new VIPCustomer() 를 호출하면 Customer()가 먼저 호출 됨
    // 클래스가 상속 받은 경우 하위 클래스의 생성자에서는 반드시 '상위 클래스의 생성자'! 를 호출 함

    // 상위클래스의 생성자를 호출하는 코드가 없는 경우 컴파일러가 자동으로 super()키워드를 호출함 --> 상위 클래스의 default생성자를 호출하게 되는것임
    // super 키워드는 하위 클래스가 상위클래스 인스턴스의 참조값을 가지게 된다
    // 상위클래스에 default 생성자가 없는 경우, 다른 생성자를 명시적으로 호출을 해주어야 한다
    //super();
    // 생성자를 명시해서 사용도 가능함
    // super는 생성된 상위 클래스의 인스턴스의 참조값을 가지므로 super를 이용하여 상위 클래스의 메서드나 맴버 변수에 접근할 수 있다.


    // 상속 시 메모리 구조
    // heap --> FIFO , stack --> LIFO
    // 힙 메모리에 할당 되고 --> 상위클래스의 맴버 변수가 메모리에 먼저 생성, 그 후에 하위 클래스의 맴버 변수가 메모리에 할당.
    // ex )    heap
    //      customerID     --------Customer(상위 클래스)
    //      customerName
    //      customerGrade
    //      bonusPoint
    //      bonusRatio
    //      agentID        ---------VIPCustomer(하위 클래스)
    //      salesRatio

    // 형변환
    // 상위 클래스로 변수를 선언하고 하위 클래스의 생성자로 인스턴스를 생성한다.
    // Customer cusotmerLee = new VIPCustomer();
    // 상위 클래스 타입의 변수에 하위 클래스 변수가 대입가능
    // VIPCustomer vCustomer = new VIPCustomer(); addCustomer(vCustomer);
    // int addCustomer(Customer customer) { }

    // 생성은 전부 다 되지만, 어떤 클래스(상위)의 타입으로 생성되느냐에 따라 접근할수있는것이 갈린다.








}