package com.example.pratice_apache_camel.apacheCamel.netty;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * packageName : com.multi.pratice.multipratice.apacheCamel.netty
 * fileName : NettyRouteBuilder
 * author : taeil
 * date : 11/28/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 11/28/23        taeil                   최초생성
 */
@Slf4j
public class NettyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        log.info("START NettyRouteBuilder NUMBER : 1");

        // 해당 route
        from("direct:startNetty")
                .process(exchange -> {
                    log.info("NettyRouteBuilder NUMBER : 2");

                    // Camel 라우트에서 받은 메시지를 가공 또는 처리
                    String message = exchange.getIn().getBody(String.class);
                    log.info("NETTY ROUTE BUILDER GET REQUEST MESSAGE ! : {}", message);

                    // exchange 컨테이너에 응답 메세지를 설정
                    exchange.getMessage().setBody(message);
                    log.info("NettyRouteBuilder : Success Send For Netty NUMBER 3");
                })
            .to("netty:tcp://localhost:9999?sync=true");
    }
}