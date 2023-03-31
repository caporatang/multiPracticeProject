package com.example.redissecurityjwt.userservice.jwttest;

import com.example.redissecurityjwt.user.domain.User;
import com.example.redissecurityjwt.user.dto.UserDTO;
import com.example.redissecurityjwt.user.repository.UserJpaRepository;
import com.example.redissecurityjwt.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * packageName : com.example.redissecurityjwt.userservice
 * fileName : JwtRequestTest
 * author : taeil
 * date : 2023/03/30
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/30        taeil                   최초생성
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JwtRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private UserService userService;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @BeforeEach
    public void before() {
        userJpaRepository.deleteAll();
        UserDTO userDTO1 = UserDTO.builder()
                .email("taeil1@naver.com")
                .userId(1L)
                .password("pass1")
                .build();

        UserDTO userDTO2 = UserDTO.builder()
                .email("taeil2@naver.com")
                .userId(2L)
                .password("pass2")
                .build();

        UserDTO userDTO3 = UserDTO.builder()
                .email("taeil3@naver.com")
                .userId(3L)
                .password("pass3")
                .build();
        userService.insertMockData(userDTO1);
        userService.insertMockData(userDTO2);
        userService.insertMockData(userDTO3);
    }

    @DisplayName("jwt Token 발급 테스트")
    @Test
    void test_1() {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<UserDTO> body = new HttpEntity<>(
                UserDTO.builder()
                        .email("taeil1@naver.com")
                        .password("pass1")
                        .build()
        );
        ResponseEntity<User> resp1 = restTemplate.exchange("http://localhost:+"+ port +"/user/v1/login", HttpMethod.POST, body, User.class);
        System.out.println("나는 jwtToken : " + resp1.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0));
        System.out.println("나는 결과의 body : " + resp1.getBody());
    }
}