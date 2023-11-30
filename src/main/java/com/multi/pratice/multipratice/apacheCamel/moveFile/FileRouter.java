package com.example.pratice_apache_camel.apacheCamel.moveFile;

import lombok.SneakyThrows;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class FileRouter {

    @SneakyThrows
    public static void main(String[] args) throws Exception {

        // 구현해둔 route chain
        FileRouteBuilder fileRouteBuilder = new FileRouteBuilder();

        CamelContext ctx = new DefaultCamelContext();

        // camelContext 에 정의한 route를 추가
        ctx.addRoutes(fileRouteBuilder);

        // 컨텍스트 호출
        ctx.start();
        // 메인메서드가 종료되서 route가 실행되지 않음을 방지
        Thread.sleep(10000 * 10000L);
    }
}
