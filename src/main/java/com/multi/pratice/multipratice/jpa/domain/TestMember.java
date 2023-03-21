package com.multi.pratice.multipratice.jpa.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * packageName : com.multi.pratice.multipratice.jpa.domain
 * fileName : TestMember
 * author : taeil
 * date : 2023/03/21
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/21        taeil                   최초생성
 */
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class TestMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}