package com.example.redissecurityjwt.user.controller;

import com.example.redissecurityjwt.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : com.example.redissecurityjwt.user.controller
 * fileName : UserController
 * author : taeil
 * date : 2023/03/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/28        taeil                   최초생성
 */
@RestController
@RequestMapping("/user/v1/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/test")
    public String testGreeting() {
        return userService.testGreeting();
    }


}