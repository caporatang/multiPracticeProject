package com.multi.pratice.multipratice.jpa.domain;


import com.multi.pratice.multipratice.jpa.listener.Auditable;
import com.multi.pratice.multipratice.jpa.listener.MemberEntityListener;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@EntityListeners(value = { MemberEntityListener.class } )
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER)
    // -> 중간에 이어주는 매핑 테이블이 생기는 경우에, 컬럼으로 조인하겠다를 명시하는 어노테이션
    // insertable, updatable --> member테이블에서는 memberHistory 테이블에 대해 인서트, 업데이트를 막음
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private List<MemberHistory> memberHistories = new ArrayList<>(); // -> 네이밍은 복수형을 사용, nullPoint를 방지하기 위한 ArrayList객체 생성
}
