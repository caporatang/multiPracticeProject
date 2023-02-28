package com.multi.pratice.multipratice.springbasic.interceptor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.interceptor.controller
 * fileName : PublicController
 * author : taeil
 * date : 2023/02/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/28        taeil                   최초생성
 */
@Slf4j
@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("hello")
    public String hello() {
        log.info("public hello controller");
         return "public hello";
    }

}