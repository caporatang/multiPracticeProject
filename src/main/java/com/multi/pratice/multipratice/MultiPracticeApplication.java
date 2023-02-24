package com.multi.pratice.multipratice;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Base64;

@SpringBootApplication
//@EnableBatchProcessing
public class MultiPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiPracticeApplication.class, args);
        // aop 테스트 중 base64값 알기위함 dGFlaWxAbmF2ZXIuY29t
        System.out.println(Base64.getEncoder().encodeToString("taeil@naver.com".getBytes()));
    }

}
