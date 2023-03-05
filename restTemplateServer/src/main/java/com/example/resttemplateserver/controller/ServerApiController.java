package com.example.resttemplateserver.controller;

import com.example.resttemplateserver.dto.Req;
import com.example.resttemplateserver.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
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
                     @PathVariable String userName,
                     @RequestHeader("x-authorization") String authorization,
                     @RequestHeader("custom-header") String customHeader)
    {
      log.info("userId : {}, userName : {}", userId, userName);
      log.info("authorization : {}, custom : {}", authorization, customHeader);
      log.info("client req : {}", user);

      return user;
    }

    @PostMapping("/json/post/user/{userId}/name/{userName}")
    public Req<User> resBodyPost(
//                            HttpEntity<String> entity,
                            @RequestBody Req<User> user,
                            @PathVariable int userId,
                            @PathVariable String userName,
                            @RequestHeader("x-authorization") String authorization,
                            @RequestHeader("custom-header") String customHeader)
    {
//        log.info("req : {}", entity.getBody());
        log.info("userId : {}, userName : {}", userId, userName);
        log.info("authorization : {}, custom : {}", authorization, customHeader);
        log.info("client req : {}", user);

        Req<User> response = new Req<>();
        response.setHeader(
                new Req.Header()
        );
        response.setResBody(
                user.getResBody()
        );

        return response;
    }

}