package com.multi.pratice.multipratice.jpa.querydsl;

/**
 * packageName : com.multi.pratice.multipratice.jpa.domain.querydsl
 * fileName : QueryDsl
 * author : taeil
 * date : 2023/04/14
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/14        taeil                   최초생성
 */
public class QueryDsl {
    // QueryDsl은 정적 타입을 이용해서 SQL과 같은 쿼리를 생성할 수 있도록 해주는 프레임워크이다.
    // Query 생성을 자동화 하여, 자바 코드로 작성할 수 있다.
    // 컴파일 시점에 문법 오류를 체크

    // 기본 제공 메서드
    // member.username.eq("member1") // username = 'member1'
    // member.username.ne("member1") //username != 'member1'
    // member.username.eq("member1").not() // username != 'member1'
    // member.username.isNotNull() //이름이 is not null
    // member.age.in(10, 20) // age in (10,20)
    // member.age.notIn(10, 20) // age not in (10, 20)
    // member.age.between(10,30) //between 10, 30
    // member.age.goe(30) // age >= 30
    // member.age.gt(30) // age > 30
    // member.age.loe(30) // age <= 30
    // member.age.lt(30) // age < 30
    // member.username.like("member%") //like 검색
    // member.username.contains("member") // like ‘%member%’ 검색
    // member.username.startsWith("member") //like ‘member%’ 검색

    // 쿼리 완성 후 결과 조회 시에는 다음과 같은 메소드를 이용!
    // fetch() : 리스트 조회, 데이터 없으면 빈 리스트 반환
    // fetchOne() : 단 건 조회
    // 결과가 없으면 : null
    // 결과가 둘 이상이면 : com.querydsl.core.NonUniqueResultException
    // fetchFirst() : limit(1).fetchOne()
    // fetchResults() : 페이징 정보 포함, total count 쿼리 추가 실행
    // fetchCount() : count 쿼리로 변경해서 count 수 조회

    // join
    // @Test
    //    public void join() {
    //        List<Member> result = queryFactory
    //                .selectFrom(member)
    //                .leftJoin(member.team, team)
    //                .where(team.name.eq("teamA"))
    //                .fetch();
    //
    //        assertThat(result)
    //                .extracting("username")
    //                .containsExactly("member1", "member3");
    //    }
    // join(), innerjoin(): 내부 조인
    // leftJoin(): left outer join
    // rightJoin(): right outer join
    // on(): on() 메소드를 체인하여 on 절을 사용할 수도 있음
}