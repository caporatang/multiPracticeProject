package com.multi.pratice.multipratice.springbasic.designpattern.observer;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.observer
 * fileName : ObserverTest
 * author : taeil
 * date : 2023/02/19
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/19        taeil                   최초생성
 */
public class ObserverTest {

    public static void main(String[] args) {
        Button button = new Button("버튼");

        // 익명 클래스를 활용 해보자 --> java swing과 비슷한 형태
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메세지 전달 : click 1 ");
        button.click("메세지 전달 : click 2 ");
        button.click("메세지 전달 : click 3 ");
        button.click("메세지 전달 : click 4 ");
    }
}