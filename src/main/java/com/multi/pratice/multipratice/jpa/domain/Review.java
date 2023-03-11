package com.multi.pratice.multipratice.jpa.domain;

import lombok.*;

import javax.persistence.*;

/**
 * packageName : com.multi.pratice.multipratice.jpa.domain
 * fileName : Review
 * author : taeil
 * date : 2023/03/11
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/11        taeil                   최초생성
 */
@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private float score;


    // ManyToOne -> many쪽에서 fk를 갖게 된다
    // --> 한명의 맴버가 여러개의 리뷰를 가질수 있음, 한권의 책에 대한 리뷰가 여러개 일수 있음
    @ManyToOne
    private Member member;

    @ManyToOne
    private Book book;

}