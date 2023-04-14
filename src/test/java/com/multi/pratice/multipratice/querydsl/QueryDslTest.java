package com.multi.pratice.multipratice.querydsl;

import com.multi.pratice.multipratice.jpa.domain.Member;
import com.multi.pratice.multipratice.jpa.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * packageName : com.multi.pratice.multipratice.querydsl
 * fileName : QueryDslTest
 * author : taeil
 * date : 2023/04/14
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/14        taeil                   최초생성
 */
@SpringBootTest
public class QueryDslTest {

    @Autowired
    private EntityManager em;

    JPAQueryFactory jpaQueryFactory;

    QMember m = QMember.member;

    @Test
    @DisplayName("queryDsl : 이름으로 조회")
    void findNameTest() {

        jpaQueryFactory = new JPAQueryFactory(em);

        Member result = jpaQueryFactory
                .select(m)
                .from(m)
                .where(m.name.eq("capo"))
                .fetchOne();

        assertThat(result.getId()).isEqualTo(2L);
    }

    @Test
    @DisplayName("queryDsl : 조건 여러개 검색")
    void findNameEmail() {

        jpaQueryFactory = new JPAQueryFactory(em);

        Member result = jpaQueryFactory
                .select(m)
                .from(m)
                .where(m.name.eq("capo")
                        .and(m.email.eq("capo@naver.com")))
                .fetchOne();

        assertThat(result.getId()).isEqualTo(2L);

    }

    @Test
    @DisplayName("queryDsl : 조회 결과를 정렬")
    void orderbyTest() {
        jpaQueryFactory = new JPAQueryFactory(em);

        List<Member> resultList = jpaQueryFactory
        // nullsLast(), nullsFirst(): null 데이터 순서 부여
                .selectFrom(m)
                .orderBy(m.id.desc(), m.name.asc().nullsLast())
                .fetch();

        assertThat(resultList.get(0).getId()).isEqualTo(5L); // desc 정렬 -> 제일 앞이 5
        assertThat(resultList.get(4).getId()).isEqualTo(1L);
    }
}