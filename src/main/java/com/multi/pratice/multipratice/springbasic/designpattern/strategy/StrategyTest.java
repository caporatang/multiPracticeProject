package com.multi.pratice.multipratice.springbasic.designpattern.strategy;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.strategy
 * fileName : StrategyTEst
 * author : taeil
 * date : 2023/02/21
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/21        taeil                   최초생성
 */
public class StrategyTest {
    public static void main(String[] args) {
        // 유연하게 사용될 객체
        Encoder encoder = new Encoder();

        String message = "hello java";


        // 기본적으로 사용할 객체를 만들고
        // 그 객체를 어떻게 사용할지 유연하게 선택 가능한것이 전략패턴임

        // base64 전략 객체
        EncodingStrategy base64 = new Base64Strategy();
        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);

        // normal 전략 객체
        EncodingStrategy normal = new NormalStrategy();
        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);

        System.out.println(base64Result);
        System.out.println(normalResult);

        // append 객체 추가
        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);

        // 기존에 사용하던 encoder를 수정하는것이 아니라,
        // 수정이 필요하다면 유연하게 다른 클래스를 추가해서 수정해야함

        // 전략 패턴을 사용하기 위해서는 꼭 세가지 이상이 필요함
        // 해당 예제 ex)
        // 1. 전략 메서드를 가진 전략 객체( Normal Strategy, Base64 Strategy )
        // 2. 전략 객체를 사용하는 컨텍스트 (Encoder)
        // 3. 전략 객체를 생성해 컨텍스트에 주입하는 클라이언트 (main 메서드)



    }
}