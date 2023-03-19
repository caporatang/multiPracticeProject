package com.multi.pratice.multipratice.jpa.service;

import com.multi.pratice.multipratice.jpa.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void test() {
        memberService.put();
        // System.out.println(">>> " + memberRepository.findByEmail("testMember@naver.com"));
        memberRepository.findAll().forEach(System.out::println);
    }
}