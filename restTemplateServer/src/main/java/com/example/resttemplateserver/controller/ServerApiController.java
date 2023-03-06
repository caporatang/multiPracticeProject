package com.example.resttemplateserver.controller;

import com.example.resttemplateserver.dto.Req;
import com.example.resttemplateserver.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.Utf8Encoder;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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


    // https://openapi.naver.com/v1/search/local.xml
    // ?query=\xea\xb0\x88\xeb\xb9\x84\xec\xa7\x91
    // &display=10
    // &start=1
    // &sort=random
    @GetMapping("/naver")
    public String naver() {

        String query = "갈비집";
        //String encode = Base64.getEncoder().encodeToString(query.getBytes(StandardCharsets.UTF_8));


        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", "중국집")
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();
        log.info("uri : {}", uri);


        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "GlEspjU0WCxbhCo0LX7T")
                .header("X-Naver-Client-Secret", "GwwMO1cTr2")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        return result.getBody();


    }
}