package com.multi.pratice.multipratice.java.basic.oop.downcastinginstanceof;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.extendss
 * fileName : VIPCustomer
 * author : taeil
 * date : 2023/01/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/18        taeil                   최초생성
 */
public class VIPCustomer extends Customer {

    private String agentId;
    double salesRatio;

    public VIPCustomer(int customerId, String customerName) {
        super(customerId, customerName);
        // 아래처럼 super를 호출해서 사용도 가능하지만, 생성자를 호출한다음 데이터를 엎어쳐서 사용도 가능하다
        salesRatio = 0.1;
        bonusRatio = 0.05;
        customerGrade = "VIP";

    }

//    public VIPCustomer() {
//        // 상위클래스의 생성자를 호출하는 코드가 없는 경우 컴파일러가 자동으로 super()키워드를 호출함 --> 상위 클래스의 default생성자를 호출하게 되는것임
//        // super 키워드는 하위 클래스가 상위클래스 인스턴스의 참조값을 가지게 된다
//        // 상위클래스에 default 생성자가 없는 경우, 다른 생성자를 명시적으로 호출을 해주어야 한다
//        //super();
//        // 생성자를 명시해서 사용도 가능함
//        super(0, "no-name");
//
//
//
//        salesRatio = 0.1;
//        bonusRatio = 0.05;
//        customerGrade = "VIP";
//
//        System.out.println("VIPCustomer() call");
//    }


    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        price -= (int) price * salesRatio;
        return price;
    }

    public String getAgentId() {
        return agentId;
    }


}