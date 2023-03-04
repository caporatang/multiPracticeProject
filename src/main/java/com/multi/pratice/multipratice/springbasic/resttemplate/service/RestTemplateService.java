package com.multi.pratice.multipratice.springbasic.resttemplate.service;

import com.multi.pratice.multipratice.springbasic.resttemplate.dto.UserRequest;
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

    public UserResponse post() {
        // 예제를 위한 테스트 주소 ~
        // http://localhost:9090/api/server/user/{userId}/{userName}

        URI uri =  UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand("100", "taeil") // --> path에 차례대로 {}에 매칭 --> userId : 100, userName : taeil
                .toUri();
        System.out.println(uri);

        // 과정 : http body -> object -> object mapper -> json -> rest template -> http body json
        UserRequest req = new UserRequest();
        req.setName("taeil2");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        // 내가 요청 보낼 서버가 어떤식으로 데이터를 내려줄지 모르겠을때는 String으로 처리해도 상관없음 -> JSON 형태로 생긴 "문자열"이 리턴됨
        // ResponseEntity<String> response = restTemplate.postForEntity(uri, req, String.class);
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);


        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();
    }


}