package com.multi.pratice.multipratice.apacheCamel.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.FutureListener;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


/**
 * packageName : com.multi.pratice.multipratice.apacheCamel.netty
 * fileName : NettyServer
 * author : taeil
 * date : 11/28/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 11/28/23        taeil                   최초생성
 */
@Slf4j
public class NettyHttpServer {
    @SneakyThrows
    public static void main(String[] args) {
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup(4);
        EventExecutorGroup eventExecutorGroup = new DefaultEventLoopGroup(4);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            var server = serverBootstrap
                    .group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ch.pipeline().addLast(
                                    eventExecutorGroup, new LoggingHandler(LogLevel.INFO)
                            );
                            ch.pipeline().addLast(
                                    new HttpServerCodec(),
                                    new HttpObjectAggregator(1024 * 1024),
                                    new NettyHttpServerHandler()
                            );
                        }
                    });
            server.bind(9999).sync()
                    .addListener(new FutureListener<>() {
                        @Override
                        public void operationComplete(io.netty.util.concurrent.Future<Void> future) throws Exception {
                            if (future.isSuccess()) {
                                log.info("Success to bind 9999");
                            } else {
                                log.error("Fail to bind 9999");
                            }
                        }
                    }).channel().closeFuture().sync();
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
            eventExecutorGroup.shutdownGracefully();
        }
    }
}