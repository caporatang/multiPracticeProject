package com.multi.pratice.multipratice.jpa.domain.mappedbytest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * packageName : com.multi.pratice.multipratice.jpa.domain.mappedbytest
 * fileName : MapMember
 * author : taeil
 * date : 2023/04/13
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/13        taeil                   최초생성
 */
@Getter
@Setter
@Entity
public class MapMember {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String username;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private MapTeam mapTeam;

    public void changeMapTeam(MapTeam mapTeam) {
        // member에 team이 세팅될 때 Team의 List<Member>에 동시에 값을 세팅해주는 메서드 -> 편의 메서드

        // changeMapTeam에 매개변수로 받은 team을 member의 team에 저장
        // 이때 저장되는 것은 DB에 외래키 그리고, team의 members에 Member 자체를 다시 세팅하여 서로 싱크를 맞춰줌
        this.mapTeam = mapTeam;
        mapTeam.getMembers().add(this);
    }
}