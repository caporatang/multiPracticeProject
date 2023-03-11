package com.multi.pratice.multipratice.jpa.domain;

import lombok.*;

import javax.persistence.*;

/**
 * packageName : com.multi.pratice.multipratice.jpa.domain
 * fileName : BookReviewInfo
 * author : taeil
 * date : 2023/03/10
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/10        taeil                   최초생성
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private Book book;

    private float averageReviewScore;

    private int reviewCount;
}