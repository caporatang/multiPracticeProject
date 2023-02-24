package com.multi.pratice.multipratice.springbasic.aop.controller;

import com.multi.pratice.multipratice.springbasic.aop.annotation.Timer;
import com.multi.pratice.multipratice.springbasic.aop.dto.User;
import org.springframework.web.bind.annotation.*;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.aop.controller
 * fileName : RestApiController
 * author : taeil
 * date : 2023/02/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/24        taeil                   최초생성
 */
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        // db logic test
        Thread.sleep(1000 * 2);
    }
}