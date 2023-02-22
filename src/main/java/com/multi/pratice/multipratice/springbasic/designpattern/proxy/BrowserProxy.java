package com.multi.pratice.multipratice.springbasic.designpattern.proxy;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.proxy
 * fileName : BrowserProxy
 * author : taeil
 * date : 2023/02/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/18        taeil                   최초생성
 */
public class BrowserProxy implements IBrowser{

    private String url;
    private Html html;

    public BrowserProxy(String url) {
        this.url = url;
    }
    @Override
    public Html show() {
        if(html == null) {
            this.html = new Html(url);
            System.out.println("BrowserProxy loading html from : " + url);
        }
        System.out.println("BrowserProxy use cache html : " + url);
        return html;
    }
}