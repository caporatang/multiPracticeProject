package com.example.redissecurityjwt.userservice;

import com.example.redissecurityjwt.user.dto.UserDTO;
import com.example.redissecurityjwt.user.repository.UserJpaRepository;
import com.example.redissecurityjwt.user.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * packageName : com.example.redissecurityjwt.userservice
 * fileName : UserServiceTest
 * author : taeil
 * date : 2023/03/29
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/29        taeil                   최초생성
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Test
    void insertMockData() {
        UserDTO userDTO1 = UserDTO.builder()
                .email("taeil1@naver.com")
                .id(1L)
                .password("pass1")
                .build();

        UserDTO userDTO2 = UserDTO.builder()
                .email("taeil2@naver.com")
                .id(2L)
                .password("pass2")
                .build();

        UserDTO userDTO3 = UserDTO.builder()
                .email("taeil3@naver.com")
                .id(3L)
                .password("pass3")
                .build();

        Long test1 = userService.insertMockData(userDTO1);
        Assertions.assertThat(1L).isEqualTo(test1);

        Long test2 = userService.insertMockData(userDTO2);
        Assertions.assertThat(2L).isEqualTo(test2);

        Long test3 = userService.insertMockData(userDTO3);
        Assertions.assertThat(3L).isEqualTo(test3);


    }

}