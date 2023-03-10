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
    // -> mysql, maria autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1 : 1 연관관계 매핑 --> jpa가 자동으로 bookId를 저장하게해줌
    // @OneToOne(optional = false)
    // -> 필수값(null을 허용하지 않겠다는 의미) optional이 default가 true임 -> true인 경우 left outer join, false로 변경시 필수값이므로 innerJoin
    @OneToOne(optional = false)
    private Book book;
    // private Long bookId;

    // 프리미티브로 타입을 선언하는 경우 컬럼의 값은 not null로 생성된다.
    private float averageReviewScore;

    private int reviewCount;
}