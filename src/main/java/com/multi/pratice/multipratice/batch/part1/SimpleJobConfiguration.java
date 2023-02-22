//package com.multi.pratice.multipratice.batch.part1;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * packageName : batch.part1
// * fileName : HelloConfiguration
// * author : taeil
// * date : 2023/01/15
// * description :
// * =======================================================
// * DATE          AUTHOR                      NOTE
// * -------------------------------------------------------
// * 2023/01/15        taeil                   최초생성
// */
//@Slf4j
//@RequiredArgsConstructor
//@Configuration // Spring Batch의 모든 Job은 @Configuration으로 등록해서 사용해야 한다.
//public class SimpleJobConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//
//
//    @Bean
//    public Job simpleJob() {
//        return jobBuilderFactory.get("simpleJob")
//                .start(simpleStep1())
//                .build();
//    }
//
//    @Bean
//    public Step simpleStep1() {
//        return stepBuilderFactory.get("simpleStep1")
//                .tasklet((contribution, chunkContext) -> {
//                    System.out.println("####");
//                    log.debug("@@@@");
//                    log.info(">>>>> This is Step1");
//                    return RepeatStatus.FINISHED;
//                })
//                .build();
//    }
//
//}