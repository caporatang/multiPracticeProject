package com.multi.pratice.multipratice.springbasic.designpattern.proxy;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.proxy
 * fileName : AopBrowser
 * author : taeil
 * date : 2023/02/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/18        taeil                   최초생성
 */
public class AopBrowser implements IBrowser {
    // spring aop 사용이 아닌, 유사한 기능들로 구현해보자. --> 해당 클래스에서는 시간을 측정해볼것임
    private String url;
    private Html html;

    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url= url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() throws InterruptedException {
        before.run();

        if(html == null) {
           this.html = new Html(url);
            System.out.println("AopBrowser html loading from : " + url);
            // 로딩이 너무 빠를수 있음, 인위적으로 쓰레드를 걸어주자
            Thread.sleep(1500);
        }

        after.run();
        System.out.println("AopBrowser html cache : " + url);
        return html;
    }
}