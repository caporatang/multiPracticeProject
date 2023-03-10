package com.multi.pratice.multipratice.jpa.domain;

import com.multi.pratice.multipratice.jpa.listener.Auditable;
import com.multi.pratice.multipratice.springbasic.designpattern.strategy.Strategy;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.security.Identity;
import java.time.LocalDateTime;

/**
 * packageName : com.multi.pratice.multipratice.jpa.domain
 * fileName : Book
 * author : taeil
 * date : 2023/03/09
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/09        taeil                   최초생성
 */

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity {

    @Id
    // -> mysql, maria autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long authorId;

    private String category;

    private Long publisherId;

    // 속성에 따른 쿼리 변경을 숙지해야한다, 로그를 잘 보자 ........
    // mappedBy 설정시, 연관키를 해당 테이블에서는 더 이상 갖지 않게된다.
    // 해당 케이스처럼 book으로 mappedBy 설정시, stackOverFlow에러가 발생된다.
    // --> Entity 릴레이션을 사용하는 경우에 ToString메서드가 순환참조가 걸리게된다.
    @ToString.Exclude  // -> 특별한 케이스가 아니라면 단방향으로 걸던지, ToString 제외가 필요하다
    @OneToOne(mappedBy = "book")
    private BookReviewInfo bookReviewInfo;
}