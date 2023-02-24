package com.multi.pratice.multipratice.springbasic.ioc;

import com.multi.pratice.multipratice.MultiPracticeApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.ioc
 * fileName : IocTest
 * author : taeil
 * date : 2023/02/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/23        taeil                   최초생성
 */
//@SpringBootApplication
public class IocTest {

    public static void main(String[] args) {
        SpringApplication.run(MultiPracticeApplication.class, args);
        // 실질적으로 이렇게 사용하지않음, 테스트 목적
        // 생성자 혹은 set 메서드, 변수, 어노테이션 등 방법을 사용해야함
        ApplicationContext context = ApplicationContextProvider.getContext();

//        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

//        Encoder encoder = new Encoder(base64Encoder);
//        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
//
//        String result = encoder.encode(url);
//        System.out.println(result);
//
//        encoder.setiEncoder(urlEncoder);
//        result = encoder.encode(url);
//        System.out.println(result);

        // 결과적으로 IOC는 스프링이 전체적으로 객체를 빈으로 만들어서 관리하고
        // 개발자가 new 이런 객체 생성없이 프로그래밍을 할수있다.
//        Encoder encoder = context.getBean(Encoder.class);
//        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
//
//        String result = encoder.encode(url);
//        System.out.println(result);

        // bean
        Encoder beanEncode = context.getBean("base64Encode", Encoder.class);
        String beanUrl = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        String beanResult = beanEncode.encode(beanUrl);
        System.out.println(beanResult);

        Encoder beanUrlEncode = context.getBean("urlEncode", Encoder.class);
        String beanUrlResult = beanUrlEncode.encode(beanUrl);
        System.out.println(beanUrlResult);


    }

    @Configuration
    class AppConfig {
        // Encoder와 같이 Base64, urlEncoder 둘다 혹은, 여러개 사용하고싶은경우
        // @Component를 사용하지 않고, Bean으로 여러개를 등록해서 사용할수있음

        @Bean("base64Encode")
        public Encoder encoder(Base64Encoder base64Encoder) {
            return new Encoder(base64Encoder);
        }
        @Bean("urlEncode")
        public Encoder encoder(UrlEncoder urlEncoder) {
            return new Encoder(urlEncoder);
        }
    }
}