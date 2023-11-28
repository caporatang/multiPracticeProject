package com.multi.pratice.multipratice.apacheCamel.netty;

import lombok.extern.slf4j.Slf4j;
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
        from("direct:startNetty")
                .routeId("nettyRoute")
                .to("netty:tcp://localhost:9999");
    }
}