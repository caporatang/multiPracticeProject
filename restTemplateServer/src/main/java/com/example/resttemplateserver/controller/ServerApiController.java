package com.example.resttemplateserver.controller;

import com.example.resttemplateserver.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * packageName : com.example.resttemplateserver.controller
 * fileName : ServerApiController
 * author : taeil
 * date : 2023/03/03
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/03        taeil                   최초생성
 */
@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    // get
    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    // post 예제
    @PostMapping("/user/{userId}/name/{userName}")
    public User post(@RequestBody User user,
                     @PathVariable int userId,
                     @PathVariable String userName)
    {
      log.info("userId : {}, userName : {}", userId, userName);
      log.info("client req : {}", user);

      return user;
    }

}