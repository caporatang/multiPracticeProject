package com.example.redissecurityjwt.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * packageName : com.example.redissecurityjwt.user.service
 * fileName : UserService
 * author : taeil
 * date : 2023/03/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/28        taeil                   최초생성
 */
@Service
@Slf4j
public class UserService {

    public String testGreeting() {
        return "그리팅 메서드를 호출";
    }
}