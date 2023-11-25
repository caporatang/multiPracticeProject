package com.multi.pratice.multipratice.apacheCamel;

/**
 * packageName : com.multi.pratice.multipratice.apacheCamel
 * fileName : FileToConsoleExample
 * author : taeil
 * date : 11/25/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 11/25/23        taeil                   최초생성
 */
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileToConsoleExample {

    public static void main(String[] args) throws Exception {
        // 어렵네..?

        // Camel 컨텍스트 생성
        CamelContext context = new DefaultCamelContext();

        // 라우트 정의
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                // 파일에서 데이터를 읽어와서 콘솔에 출력
                from("file:inputFolder?noop=true")  // inputFolder에서 파일을 읽어옴 -> noop true 파일을 ㅇ릭은 후에 파일을 원래 위치에 남겨두도록 지정
                        .to("log:?level=INFO&showBody=true&showHeaders=true")  // 콘솔에 출력
                        .end();
            }
        });

        // Camel 컨텍스트 시작
        context.start();

        // 애플리케이션 실행 중지를 대기
        Thread.sleep(10000);

        // Camel 컨텍스트 정리
        context.stop();
    }
}
