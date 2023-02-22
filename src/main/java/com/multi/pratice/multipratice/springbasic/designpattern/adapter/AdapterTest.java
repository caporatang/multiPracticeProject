package com.multi.pratice.multipratice.springbasic.designpattern.adapter;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.adapter
 * fileName : AdapterTest
 * author : taeil
 * date : 2023/02/17
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/17        taeil                   최초생성
 */
public class AdapterTest {

    // 앞에서 만든 헤어드라이기, 에어컨, 청소기를 사용할수있는 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }

    public static void main(String[] args) {
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        // 콘센트에는 110v 짜리만 사용할수있는데 220짜리 청소기를 사용하려고 해서 에러가 남
        Cleaner cleaner = new Cleaner();
        // connect(cleaner);

        // 기본 생성자를 이용해서, 중간에 한번 인터페이스를 거쳐서 연결되는것이 어댑터패턴
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);
        // 중간에 연결되는 인터페이스를 공통으로 하나로 묶어서 사용하면 더 좋을듯!
        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);


    }
}