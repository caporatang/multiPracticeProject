package com.example.redissecurityjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RedisSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisSecurityJwtApplication.class, args);
    }

}
