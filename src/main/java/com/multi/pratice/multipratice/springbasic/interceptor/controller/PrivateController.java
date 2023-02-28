package com.multi.pratice.multipratice.springbasic.interceptor.controller;

import com.multi.pratice.multipratice.springbasic.interceptor.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.interceptor.controller
 * fileName : PrivateController
 * author : taeil
 * date : 2023/02/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/28        taeil                   최초생성
 */
@RestController
@Auth
@Slf4j
@RequestMapping("/api/private")
public class PrivateController {

    @GetMapping("/hello")
    public String hello() {
        log.info("private hello Controller");
        return "private hello";
    }

}