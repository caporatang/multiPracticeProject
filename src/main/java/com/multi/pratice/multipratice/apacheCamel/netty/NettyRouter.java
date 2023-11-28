package com.multi.pratice.multipratice.apacheCamel.netty;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * packageName : com.multi.pratice.multipratice.apacheCamel.netty
 * fileName : NettyRouter
 * author : taeil
 * date : 11/28/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 11/28/23        taeil                   최초생성
 */
@Slf4j
public class NettyRouter {

    @SneakyThrows
    public static void main(String[] args) {
        NettyRouteBuilder nettyRouteBuilder = new NettyRouteBuilder();

        CamelContext camelContext = new DefaultCamelContext();

        camelContext.addRoutes(nettyRouteBuilder);

        camelContext.start();

        ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
        producerTemplate.sendBody("direct:startNetty", "Message for Netty");

        Thread.sleep(10000 * 10000L);
    }
}