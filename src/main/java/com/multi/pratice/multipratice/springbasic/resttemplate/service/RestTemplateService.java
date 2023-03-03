package com.multi.pratice.multipratice.springbasic.resttemplate.service;

import com.multi.pratice.multipratice.springbasic.resttemplate.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.resttemplate.service
 * fileName : RestTemplateService
 * author : taeil
 * date : 2023/03/03
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/03        taeil                   최초생성
 */
@Service
public class RestTemplateService {

    // http://localhost:8080/rest/client
    // response
    public UserResponse hello() {
        // 다른 서버와 restTemplate로 통신하기
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "aaaa")
                .queryParam("age", 99)
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();

        // get은 조회나 가져올때의 get의 의미가 아님 -> HTTP METHOD의 GET임
        // getForObject
        // String result = restTemplate.getForObject(uri, String.class);

        // getForEntity --> status코드나 상세한걸 알수있기 때문에 Entity가 더 좋을수있음
        // ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        // System.out.println(result.getStatusCode());
        // System.out.println(result.getBody());

        // JSON 받아오기
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);


        return result.getBody();
    }


}