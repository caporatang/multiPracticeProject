package com.multi.pratice.multipratice.jpa.domain.mappedbytest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.multi.pratice.multipratice.jpa.domain.mappedbytest
 * fileName : MapTeam
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
public class MapTeam {

    @Id
    @GeneratedValue
    private Long id;

    private String teamName;

    // mappedBy -> 연관관계의 주인은 1:N의 경우 N 쪽으로, 자신이 이 연관관계의 주인이 '아님'을 설정
    // 데이터베이스 테이블의 다대일, 일대다 관계에서는 항상 다 쪽이 외래키를 가짐
    // 따라서 항상 다(N)쪽이 연관관계의 주인이 되므로 @ManyToOne에는 mappedBy 속성이 없음
    @OneToMany(mappedBy = "mapTeam")
    private List<MapMember> members = new ArrayList<>();
}