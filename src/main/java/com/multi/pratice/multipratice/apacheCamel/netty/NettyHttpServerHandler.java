package com.example.pratice_apache_camel.apacheCamel.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;

/**
 * packageName : com.multi.pratice.multipratice.apacheCamel.netty
 * fileName : NettyHttpServerHandler
 * author : taeil
 * date : 11/28/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 11/28/23        taeil                   최초생성
 */
@Slf4j
public class NettyHttpServerHandler extends ChannelInboundHandlerAdapter {

    private ProducerTemplate producerTemplate;

    public NettyHttpServerHandler(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 받은 메시지를 Camel 라우트로 전송하고 응답을 받음
        String message = (String) msg;
        log.info("I AM ChannelRead 1 : {}", message);

        // Camel 라우트 호출
        String response = producerTemplate.requestBody("direct:startNetty", message, String.class);
        log.info("I AM ChannelRead 2 : {}", response);

        // 응답을 Netty 클라이언트에게 전송
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
        log.info("I AM ChannelRead 3 Send Success");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("Exception caught in NettyHttpServerHandler", cause);
        ctx.close();
    }
}