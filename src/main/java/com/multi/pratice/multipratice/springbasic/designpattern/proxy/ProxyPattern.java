package com.multi.pratice.multipratice.springbasic.designpattern.proxy;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.proxy
 * fileName : ProxyPattern
 * author : taeil
 * date : 2023/02/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/18        taeil                   최초생성
 */
public class ProxyPattern {
    // Proxy는 대리인 이라는 뜻, 뭔가를 대신해서 처리하는 것
    // Proxy Class를 통해 대신 전달 하는 형태로 설계, 실제 Client는 Proxy로 부터 결과를 받음
    // Cache의 기능으로도 활용이 가능함
    // SOLID 중 개방폐쇄 원칙(OCP)과 의존 역전 원칙 (DIP)를 따른다.

    // 대표적으로 AOP pattern을 활용하는 프로그래밍을 예로 들수있음

    // 작업을 나눠서 구현하는것을 뜻함..!
    // 오버헤드가 큰 작업과 작은 작업을 나눠서 작은 작업을 프록시에서 처리하도록 하는것임.
    // AopBrowser 클래스를 보면, 시간을 재는 기능이 있는데 그것이 프록시 패턴의 활용임.





}