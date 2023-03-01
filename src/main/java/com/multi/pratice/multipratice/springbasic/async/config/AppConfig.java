package com.multi.pratice.multipratice.springbasic.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


/**
 * packageName : com.multi.pratice.multipratice.springbasic.async.config
 * fileName : AppConfig
 * author : taeil
 * date : 2023/03/01
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/01        taeil                   최초생성
 */
@Configuration
public class AppConfig {
    // 정해진 스레드풀의 갯수를 만들어서 늘려보자

    @Bean("async-thread")
    public Executor asyncThread() {
        // 간략한 threadPool에 대한 이해
        // 1. core에 10개가 먼저 할당된 후, 코어가 꽉차면
        // 2. Queue에 10개가 할당된 후, Queue까지 꽉차게 된다면 다시 core의 갯수가 늘어남 10 -> 20
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(100);
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(10);
        threadPoolTaskExecutor.setThreadNamePrefix("Async-");
        return threadPoolTaskExecutor;
    }

}