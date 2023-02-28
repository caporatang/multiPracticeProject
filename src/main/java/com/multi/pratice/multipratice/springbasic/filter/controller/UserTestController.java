package com.multi.pratice.multipratice.springbasic.filter.controller;

import com.multi.pratice.multipratice.springbasic.filter.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.filter.controller
 * fileName : ApiControllerTest
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
@RequestMapping("/api/temp")
public class UserTestController {

    @PostMapping("")
    public User user(@RequestBody User user) {
        // 첫번째 중괄호에는 뒤에 넣은 2의 매개변수의 toString이 들어감
        log.info("Temp : {}", user);
        return user;
    }

}