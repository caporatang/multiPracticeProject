package com.example.redissecurityjwt.redis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

/**
 * packageName : com.example.redissecurityjwt.redis.domain
 * fileName : RedisUserEntity
 * author : taeil
 * date : 2023/03/30
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/30        taeil                   최초생성
 */
@Getter
@AllArgsConstructor
@RedisHash(value = "RedisUserEntity")
//@RedisHash(value = "RedisUserEntity", timeToLive = 30)
public class RedisUserEntity {

    @Id
    private Long id;
    private String email;
    private String password;

}