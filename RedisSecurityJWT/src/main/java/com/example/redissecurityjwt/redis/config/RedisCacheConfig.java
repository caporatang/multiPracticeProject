package com.example.redissecurityjwt.redis.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * packageName : com.example.redissecurityjwt.redis.config
 * fileName : RedisCacheConfig
 * author : taeil
 * date : 2023/04/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/02        taeil                   최초생성
 */
public class RedisCacheConfig {

//    @Bean
//    public RedisCacheManager redisCacheManager() {
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .serializeKeysWith(
//                        RedisSerializationContext.SerializationPair.fromSerializer(
//                                new StringRedisSerializer()))
//                .serializeValuesWith(
//                        RedisSerializationContext.SerializationPair.fromSerializer(
//                                new GenericJackson2JsonRedisSerializer()));
//
//        return RedisCacheManager.RedisCacheManagerBuilder
//                .fromConnectionFactory(redisConnectionFacroty())
//                .cacheDefaults(redisCacheConfiguration)
//                .build();
//
//    }

}