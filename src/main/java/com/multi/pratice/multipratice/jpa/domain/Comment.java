package com.multi.pratice.multipratice.jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * packageName : com.multi.pratice.multipratice.jpa.domain
 * fileName : Comment
 * author : taeil
 * date : 2023/04/09
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/09        taeil                   최초생성
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true) // -> BaseEntity
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @ToString.Exclude
    private Review review;

    // LocalDateTime test Only
    // -> jpa의 auto ddl 을 사용하게 되면 자동으로 컬럼의 데이터는 datetime(6)으로 생성되게 된다.
    @Column(columnDefinition = "datetime")
    private LocalDateTime commentedAt;

}