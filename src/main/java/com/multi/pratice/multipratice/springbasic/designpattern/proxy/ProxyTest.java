package com.multi.pratice.multipratice.springbasic.designpattern.proxy;

import java.util.concurrent.atomic.AtomicLong;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.proxy
 * fileName : ProxyTest
 * author : taeil
 * date : 2023/02/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/18        taeil                   최초생성
 */
public class ProxyTest {

    public static void main(String[] args) throws InterruptedException {
        // proxy 패턴을 가지고 cache 기능을 구현해보자
        // 아래에서 처럼 browser를 4번 호출하면 4번 다 www.naver.com이라는 url이 출력되는데, 이를 proxy 패턴을 사용해서 바꿔보자.
        /*
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        */

        // 로딩은 한번 -> 나머지는 캐시된 html을 가져옴
        /*
        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        */

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    // 현재 시간에서 시작 시간을 빼주자 -> 끝나는 시간
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );
        // 첫번째 실행은 1.5초가 걸림 -> AOP 브라우저 클래스에 thread sleep을 걸어놨기 때문에
        aopBrowser.show();
        System.out.println("loading time : "+ end.get());

        // 두번째 호출은 캐시를 사용하기 때문에 0초가 걸림
        aopBrowser.show();
        System.out.println("loading time : "+ end.get());
    }
}