package com.multi.pratice.multipratice.jpa.service;

import com.multi.pratice.multipratice.jpa.domain.Member;
import com.multi.pratice.multipratice.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * packageName : com.multi.pratice.multipratice.jpa.service
 * fileName : MemberService
 * author : taeil
 * date : 2023/03/19
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/19        taeil                   최초생성
 */
@Service
@RequiredArgsConstructor
public class MemberService {

    private final EntityManager entityManager;
    private final MemberRepository memberRepository;

    @Transactional
    public void put() {
        // member는 new상태로 비영속상태다, 영속성 컨텍스트에 의해 관리되지 않는 상태
        // 사용하지 않기 때문에 GC가 치워줄것임
        Member member = new Member();

        member.setName("testMember");
        member.setEmail("testMember@naver.com");

        System.out.println("-------------------------------------------------");
        // 영속화 시켜보자 -> 해당 객체를 영속성 컨텍스트가 관리하는 상태로 만듬
        entityManager.persist(member);

        // 준영속 상태 -> 영속화 되었던 객체를 분리하여, 영속성 컨텍스트 밖으로 꺼내는 동작
        entityManager.detach(member); // --> 컨텍스트에서 뺐기 때문에 아래에서 이름을 set해도 변경되지 않음


        // name의 정보가 변경 -> 영속성 컨텍스가 관리하는 entity의 경우 setter를 통해서 객체 정보가 변경되면 -> 별도로 DB와 데이터 정합성을 맞춰줌
        // -> 자동으로 update 쿼리를 날려줌 --> 더티 체킹 -> 변경감지 !
        // 영속성 컨텍스트에서 가지고 있는 엔티티 객체는 처음 컨텍스트에 로드할때, 일종의 스냅샷으로 복사해서 가지고 있다가
        // 변경된 내용을 디비에 커밋해야 하는 시점에 DB와 스냅샷과 비교하여 자동으로 적용해줌
        member.setName("newUserAfterPersist");

        // 준영속 상태의 객체를 merge하면 다시 데이터가 변경되는것을 알수있음
        entityManager.merge(member);


        // newUserAfterPersist의 변경, 디비에 커밋 시키고 난 후 아래에서 클리어
        // 적용되는 시점을 잘 알고 사용하도록 하자 .
        entityManager.flush();
        // 다시 detached를 하게 되면 변경 하려고 작업했던것들을 모두 clear 시킨다
        // entityManager.clear();

        // remove를 시키면 remove시킨 특정 객체는 사용할수없음
        // remove는 영속화된 객체에 대해서 적용해야함
        entityManager.remove(member);

        Member member1 = memberRepository.findById(1L).get();
        entityManager.remove(member1);



    }



}