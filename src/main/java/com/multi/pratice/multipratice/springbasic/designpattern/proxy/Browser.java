package com.multi.pratice.multipratice.springbasic.designpattern.proxy;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.proxy
 * fileName : Browser
 * author : taeil
 * date : 2023/02/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/18        taeil                   최초생성
 */
public class Browser implements IBrowser {
    private String url;

    public Browser(String url) {
        this.url = url;
    }

    @Override
    public Html show() {
        System.out.println("browser loading html from : " + url);
        return new Html(url);
    }
}