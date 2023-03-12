package com.multi.pratice.multipratice.jpa.service;

import com.multi.pratice.multipratice.jpa.domain.Member;
import com.multi.pratice.multipratice.jpa.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.SQLOutput;

/**
 * packageName : com.multi.pratice.multipratice.jpa.service
 * fileName : EntityManagerTest
 * author : taeil
 * date : 2023/03/12
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/12        taeil                   최초생성
 */
@SpringBootTest
@Transactional
public class EntityManagerTest {
    // 영속성 cache가 flush되어 db에 반영되는것은,
    // 1. flush메서드를 명시적으로 실행하는 시점
    // 2. Transaction이 끝나서 db에 commit되는 시점
    // 3. 복잡한 조회 조건의 jpql 쿼리가 실행되는 시점

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;
    @Test
    void entityManagerTest() {
        // jpql을 사용해서 테스트 해보자
        System.out.println(entityManager.createQuery("select m from Member m").getResultList());
    }

    @Test
    void cacheFindTest() {
        // entityManager는 cache를 가지고있음 --> 조회 메서드를 3번을 요청함
        // --> 3번 조회를 하는게 아닌, 한번 조회 쿼리를 날리고, 영속성 컨텍스트 내부에 존재하는 entity cache에서 가져온 결과를 가져옴
        // --> 이를 jpa 1차 캐시라고함

        // 1차 캐시가 적용되고 안되고의 차이점
        // 1차 캐시는 map의 형태로 만들어짐
        // key는 id값 value는 entity가 들어감.. -> id로 조회시, 영속성 컨텍스트에 존재하는 1차캐시에 엔티티를 조회하고
        // 엔티티가 있다면 바로 값을 리턴하고, 엔티티가 존재하지 않는다면 쿼리를 실제 db에 날려 조회하고, 1차 캐시에 저장한 후 데이터를 리턴함

//        System.out.println(memberRepository.findByEmail("taeil@naver.com"));
//        System.out.println(memberRepository.findByEmail("taeil@naver.com"));
//        System.out.println(memberRepository.findByEmail("taeil@naver.com"));
//        System.out.println(memberRepository.findById(2L).get());
//        System.out.println(memberRepository.findById(2L).get());
//        System.out.println(memberRepository.findById(2L).get());

        // delete나 update를 할떄도 조회를 먼저한 후 진행함
        // jpa내부적으로는 id로 조회 하는 일이 빈번하게 일어남
        // 하나의 트랜잭 안에서 동작할 때에는 1차 캐시를 사용함으로써 성능저하를 방지
        memberRepository.deleteById(1L);

    }


    @Test
    void cacheFindTest2() {
        // update 케이스를 알아보자
        // repository.save 메서드 구현체에 @Transactinal이 걸려있음. --> 사용하는곳에서 따로 지정하지 않으면 save메서드 하나당 하나의 트랜잭션으로 처리
        // 이 테스트 클래스 전체에 @Transactional을 선언한다면, 아래처럼 save 메서드 두개를 사용해도 하나의 트랜잭션으로 처리되어, update쿼리가 한번만 실행된다.

        // --> entity 캐시쪽에서 쿼리를 merging처리하고 -> 1번 일어난 쿼리를 flush로 db에 반영시킨것.


        Member member = memberRepository.findById(1L).get();
        member.setName("taeilllll");

        memberRepository.save(member);

        System.out.println("----------------------------------------");
        member.setEmail("caporatnaggggg@naver.com");
        memberRepository.save(member);

        // 영속성 캐시를 db에 반영시키는 메서드인것.
        // 영속성 캐시에서 보이는 데이터와, db에 있는 데이터가 동기화된다.
        // memberRepository.flush();

        // --> findById를 했을 때, update쿼리가 실행되지 않았음에도 >>> 1 에 대한 결과는 이메일이 변경된 값으로 출력된다.
        // --> 실제 db와 entity 캐시 사이에 데이터가 맞지 않는 순간이 발생함
        System.out.println(">>> 1 " + memberRepository.findById(1L).get());

        // flush메서드 실행 -> update 쿼리 실행 --> db 반영
        memberRepository.flush();
        // 조회 쿼리 실행하지 않고 영속성 캐시의 영향을 받아 데이터 리턴
        System.out.println(">>> 2 " + memberRepository.findById(1L).get());
    }

    @Test
    void cacheFindTest3() {
        // auto flush 케이스
        Member member = memberRepository.findById(1L).get();
        member.setName("taeilllll");

        memberRepository.save(member);

        System.out.println("----------------------------------------");
        member.setEmail("caporatnaggggg@naver.com");
        memberRepository.save(member);

        System.out.println(memberRepository.findAll()); // select * from member

    }


}