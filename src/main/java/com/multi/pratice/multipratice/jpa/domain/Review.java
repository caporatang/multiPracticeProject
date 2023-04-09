package com.multi.pratice.multipratice.jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    // ManyToOne의 fetch default는 Eager -> ToString.Exclude를 해도 Eager로 설정 되어있기 때문에 쿼리가 발생된다.
    // getter를 통해 가지고 오지 않으면 쿼리가 발생되지 않는다.
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude // -> n + 1 확인용 ToString 제외
    private Member member;

    // ManyToOne의 fetch default는 Eager -> ToString.Exclude를 해도 Eager로 설정 되어있기 때문에 쿼리가 발생된다.
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude // -> n + 1 확인용 ToString 제외
    private Book book;

    // oneToMany의 fetch default는 lazy
    // reviewRepositoryTest -> findAll을 했을때 review 쿼리 한개를 조인으로 실행시킨다고 생각을 하지만,
    // 실제로는 review 쿼리 한개에, comment 쿼리 두개(넣어둔 데이터 갯수가 2개)가 발생된다.
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private List<Comment> comments;

    // FetchType을 Lazy로 바꾼다고 무조건 N + 1이 해결 되는것은 아님 -> 쿼리를 날리는 시점을 변경 하는 것 뿐, 쿼리의 갯수 까지는 막지 못함
}