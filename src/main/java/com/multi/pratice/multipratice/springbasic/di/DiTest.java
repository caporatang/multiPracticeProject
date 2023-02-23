package com.multi.pratice.multipratice.springbasic.di;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.ioc
 * fileName : IocTest
 * author : taeil
 * date : 2023/02/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/23        taeil                   최초생성
 */
public class DiTest {
    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        //Base 64 encoding -> 객체 생성해서 디자인패턴이나, DI같은 개념 미적용코드
//        IEncoder encoder = new Base64Encoder();
//        String result = encoder.encode(url);
//        System.out.println( "Base64 " + result);

        // url encoding -> 객체 생성해서 디자인패턴이나, DI같은 개념 미적용코드
//        IEncoder urlEncoder = new UrlEncoder();
//        String urlResult = urlEncoder.encode(url);
//        System.out.println("url " + urlResult);

        // URL이나 BASE64를 encoder클래스에 외부에서 주입해서 원하는 결과를 도출하는것이 의존성 주입(DI)임.
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);
        System.out.println(result);


    }
}