package com.example.redissecurityjwt.user.domain;

import com.example.redissecurityjwt.config.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

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
    private Long id;
    private String email;
    private String password;
}