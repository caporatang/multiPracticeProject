package com.example.redissecurityjwt.redis.repository;

import com.example.redissecurityjwt.redis.domain.RedisUserEntity;
import org.springframework.data.repository.CrudRepository;

public interface RedisUserRepository extends CrudRepository<RedisUserEntity, Long> {
}
