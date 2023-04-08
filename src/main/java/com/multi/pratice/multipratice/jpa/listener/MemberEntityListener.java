package com.multi.pratice.multipratice.jpa.listener;

import com.multi.pratice.multipratice.jpa.domain.Member;
import com.multi.pratice.multipratice.jpa.domain.MemberHistory;
import com.multi.pratice.multipratice.jpa.repository.MemberHistoryRepository;
import com.multi.pratice.multipratice.jpa.support.BeanUtils;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * packageName : com.multi.pratice.multipratice.jpa.domain
 * fileName : MemberEntityListener
 * author : taeil
 * date : 2023/03/09
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/09        taeil                   최초생성
 */
public class MemberEntityListener {

    //@PrePersist
    @PostPersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o) {
        MemberHistoryRepository memberHistoryRepository = BeanUtils.getBean(MemberHistoryRepository.class);

        Member member = (Member) o;

        MemberHistory memberHistory = new MemberHistory();
        memberHistory.setName(member.getName());
        memberHistory.setEmail(member.getEmail());
        memberHistory.setMember(member);
        memberHistory.setHomeAddress(member.getHomeAddress());
        memberHistory.setCompanyAddress(member.getCompanyAddress());

        memberHistoryRepository.save(memberHistory);
    }


}