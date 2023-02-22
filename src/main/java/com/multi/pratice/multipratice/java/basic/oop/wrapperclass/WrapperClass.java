package com.multi.pratice.multipratice.java.basic.oop.wrapperclass;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WrapperClass {
    public static void main(String[] args) {
        // 기본타입(primitive) : int, long, float, double, boolean, char ..등
        // Wrapper class : Integer, Long, Float, Double, Boolean ..등

        // wrapperClass는 기본타입 데이터를 객체로 포장해주는 클래스
        // 참조형 변수에 들어있는 주소를 기본형 변수에 넣을 수 없다.
        // 자바는 변수가 선언될 때 변수에 들어가는 타입이 결정되기 때문이다.

        // 기본적으로 기본형과 기본형에 대한 포장클래스간만 가능하다.
        // 기본형 변수에 참조형 값을 어싸인한다. -> 오토박싱
        // 오토박싱
        int a = 1;
        Integer intBoxing = a;
        System.out.println("나는 오토박싱" + intBoxing);

        // 작은개념 >> 큰개념
        // 참조형에 기본형을 어싸인한다. -> 오토언박싱
        Double aDouble = 3.14;
        double autoUnBoxing = aDouble;
        System.out.println("나는 오토언박싱" + autoUnBoxing);

        // 성능만 놓고 보았을때.. 동일타입이 연산속도가 훨씬 빠르기 때문에, 캐스팅여부를 확인하고 연산하도록 하는 습관을 갖자..
        // 오토박싱 연산 Long과 long
        long t = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i < 1000000; i++) {
            sum += i;
        }
        // Long long 연산 시간 : 24 ms
        System.out.println("Long long 연산 시간 : " + (System.currentTimeMillis() - t) + " ms");


        long t2 = System.currentTimeMillis();
        long sum2 = 0L;
        for (long i = 0; i < 1000000; i++) {
            sum2 += i;
        }
        // long long 연산 시간 : 7 ms
        System.out.println("long long 연산 시간 : " + (System.currentTimeMillis() - t2) + " ms") ;


    }
}

