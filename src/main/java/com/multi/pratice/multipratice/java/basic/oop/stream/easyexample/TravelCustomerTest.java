package com.multi.pratice.multipratice.java.basic.oop.stream.easyexample;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.stream.easyexample
 * fileName : TravelCustomerTest
 * author : taeil
 * date : 2023/03/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/24        taeil                   최초생성
 */
public class TravelCustomerTest {

    public static void main(String[] args) {

        TravelCustomer customerLee = new TravelCustomer("리순신", 40, 100);
        TravelCustomer customerKim = new TravelCustomer("김유신", 20, 100);
        TravelCustomer customerHong = new TravelCustomer("홍길동", 13, 50);

        List<TravelCustomer> customerList = new ArrayList<>();
        customerList.add(customerLee);
        customerList.add(customerKim);
        customerList.add(customerHong);

        System.out.println("고객 명단 출력");
        // customerList.stream().map(c -> c.getName()).forEach(s -> System.out.println(s));
        customerList.stream().map(TravelCustomer::getName).forEach(System.out::println);

        System.out.println("여행 비용");
        // System.out.println(customerList.stream().mapToInt(c -> c.getPrice()).sum());
        System.out.println(customerList.stream().mapToInt(TravelCustomer::getPrice).sum());

        System.out.println("20세 이상 고객이름 정렬");
        //                            이 변수 c와                   이 변수 c 는 다른 데이터다
        // customerList.stream().filter(c -> c.getAge() >= 20).map(c -> c.getName()).sorted().forEach(s -> System.out.println(s));
        customerList.stream().filter(c -> c.getAge() >= 20).map(TravelCustomer::getName).sorted().forEach(System.out::println);

    }

}