package com.example.resttemplateserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestTemplateServerApplication {
	// restTemplate 테스트 및 gradle multimodule 테스트용
	public static void main(String[] args) {
		SpringApplication.run(RestTemplateServerApplication.class, args);
	}

}
