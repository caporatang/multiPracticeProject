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


    @Embedded
    @AttributeOverrides({
            // Address를 두번씩 선언하면 내부에 있는 컬럼이 2번씩 선언이 된다.
            // 한 테이블에 2번씩 선언은 허용되지 않기 때문에, 어노테이션을 사용해서 해당 속성값을 재정의 하겠다는 의미다.
            // 하나의 Address객체로 다른 이름으로 여러개로 사용 할수있음 -> 남용 한다면 가독성을 해치기 때문에 따로 선언해서 사용할지 하나의 객체로 할지 판단하는게 중요
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "district", column = @Column(name = "home_district")),
            @AttributeOverride(name = "detail", column = @Column(name = "home_address_detail")), // -> Addres객체에 @Column에 정의한 값은 이 이름으로 치환된다.
            @AttributeOverride(name = "zipCode", column = @Column(name = "home_zip_code"))
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "company_city")),
            @AttributeOverride(name = "district", column = @Column(name = "company_district")),
            @AttributeOverride(name = "detail", column = @Column(name = "company_address_detail")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "company_zip_code"))
    })
    private  Address companyAddress;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    @ToString.Exclude
    private List<MemberHistory> memberHistories = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();
}
