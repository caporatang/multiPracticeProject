package com.example.redissecurityjwt.redis;

/**
 * packageName : com.example.redissecurityjwt.redis
 * fileName : RedisCache
 * author : taeil
 * date : 2023/04/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/02        taeil                   최초생성
 */
public class RedisCache {
    // Annotation
    // @EnableCaching -> SpringBoot에게 캐싱 기능이 필요하다고 전달 -> SpringBoot Starter class에 적용
    // @Cacheable -> DB에서 애플리케이션으로 데이터를 가져오고 Cache에 저장하는데 사용, DB에서 데이터를 가져오는 메서드에 적용
    // @CachePut -> DB의 데이터 업데이트가 있을 때 Redis Cache에 데이터를 업데이트, DB에서 PUT/PATCH와 같은 업데이트에서 사용
    // @CacheEvict -> DB의 데이터 삭제가 있을 때 Redis Cache에 데이터를 삭제, DB에서 DELETE와 같은 삭제에서 사용
}