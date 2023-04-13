package com.multi.pratice.multipratice.jpa.domain.mappedbytest.service;

import com.multi.pratice.multipratice.jpa.domain.mappedbytest.domain.MapMember;
import com.multi.pratice.multipratice.jpa.domain.mappedbytest.domain.MapTeam;
import com.multi.pratice.multipratice.jpa.domain.mappedbytest.repository.MapMemberJpaRepository;
import com.multi.pratice.multipratice.jpa.domain.mappedbytest.repository.MapTeamJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.multi.pratice.multipratice.jpa.domain.mappedbytest
 * fileName : MapTestService
 * author : taeil
 * date : 2023/04/13
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/13        taeil                   최초생성
 */
@Service
@RequiredArgsConstructor
public class MapTestService {

    private final MapTeamJpaRepository mapTeamJpaRepository;
    private final MapMemberJpaRepository mapMemberJpaRepository;

    public void mappedByTest() {
        MapTeam mapTeam = new MapTeam();
        mapTeam.setTeamName("teamA");
        mapTeamJpaRepository.save(mapTeam);

        MapMember mapMember = new MapMember();
        mapMember.setUsername("KIM TAE IL");
        mapMember.setMapTeam(mapTeam);

        mapTeam.getMembers().add(mapMember); //-> 편의 메서드를 정의해서 더 손쉽게 사용해보자

        mapMemberJpaRepository.save(mapMember);

        List<MapMember> findMembers = mapTeam.getMembers();
        for (MapMember member : findMembers) {
            // 테스트 성공 여부는 실행시 Team의 members에 저장한 member가 콘솔에 찍혀야 하고,
            // Team 테이블에는 Member에 대한 데이터가 없어야 함
            // 실행결과 : findMember.getUserName() = KIM TAE IL
            System.out.println("findMember.getUserName() = " + member.getUsername());
        }
    }

    public void ConvenienceMethodTest() {
        MapTeam mapTeam = new MapTeam();
        mapTeam.setTeamName("teamB");
        mapTeamJpaRepository.save(mapTeam);

        MapMember mapMember = new MapMember();
        mapMember.setUsername("KIM KIM KIM");
        mapMember.setMapTeam(mapTeam);
        mapMember.changeMapTeam(mapTeam);
        mapMemberJpaRepository.save(mapMember);

        List<MapMember> dbResult = mapTeam.getMembers();
        for(MapMember member2 : dbResult) {
            System.out.println("findMember.getUserName() = " + member2.getUsername());
        }

    }
}