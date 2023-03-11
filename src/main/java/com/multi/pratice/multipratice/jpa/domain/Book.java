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
import java.util.ArrayList;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long authorId;

    private String category;

    // private Long publisherId;

    @ToString.Exclude
    @OneToOne(mappedBy = "book")
    private BookReviewInfo bookReviewInfo;

    @OneToMany
    @JoinColumn(name = "book_id") // 까먹지 말자 중간 테이블 방지
    @ToString.Exclude // stackOverFlow 방지
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne
    @ToString.Exclude
    private Publisher publisher;

}