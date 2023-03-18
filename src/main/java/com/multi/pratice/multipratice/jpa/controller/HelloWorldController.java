package com.multi.pratice.multipratice.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/v1")
public class HelloWorldController {


    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world";
    }
}
