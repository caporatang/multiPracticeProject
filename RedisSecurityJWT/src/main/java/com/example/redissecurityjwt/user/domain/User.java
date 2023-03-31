package com.example.redissecurityjwt.user.domain;

import com.example.redissecurityjwt.board.domain.Board;
import com.example.redissecurityjwt.config.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * packageName : com.example.redissecurityjwt.user.domain
 * fileName : User
 * author : taeil
 * date : 2023/03/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/28        taeil                   최초생성
 */


@Entity
@Getter
@Setter
@ToString
@Table(name = "USER")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @ToString.Exclude
    private Set<UserRole> authorities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Board> boards = new ArrayList<>();

}