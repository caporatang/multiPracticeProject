package com.example.redissecurityjwt.user.domain;

import com.example.redissecurityjwt.config.BaseTimeEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * packageName : com.example.redissecurityjwt.user.domain
 * fileName : Authority
 * author : taeil
 * date : 2023/03/29
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/29        taeil                   최초생성
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "USER_ROLE")
@IdClass(UserRole.class) // -> 둘다 유니크한게 검색 시 편하기 때문
public class UserRole extends BaseTimeEntity implements GrantedAuthority {

    @Id
    @Column(name = "id")
    private Long id;
    @Id
    private String authority;

    public UserRole(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

}