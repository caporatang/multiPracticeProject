package com.multi.pratice.multipratice;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.Base64;

@SpringBootApplication
//@EnableBatchProcessing
@ServletComponentScan // -> 정의한 filter를 특정 객체에만 적용시키고 싶을때 사용
public class MultiPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiPracticeApplication.class, args);

    }

}
