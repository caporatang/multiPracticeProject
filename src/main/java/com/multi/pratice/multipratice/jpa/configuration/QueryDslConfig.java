package com.multi.pratice.multipratice.jpa.configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * packageName : com.multi.pratice.multipratice.jpa.configuration
 * fileName : QueryDslConfig
 * author : taeil
 * date : 2023/04/14
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/14        taeil                   최초생성
 */
@Configuration
public class QueryDslConfig {
    // queryDsl이 query를 생성할 수 있도록 EntityManager를 주입

    @PersistenceContext // -> EntityManager를 빈으로 주입할 때 사용하는 어노테이션
    private EntityManager entityManager;

    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}