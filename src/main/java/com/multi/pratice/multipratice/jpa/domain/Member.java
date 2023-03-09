package com.multi.pratice.multipratice.jpa.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity // --> jpa에서 관리하는 entitiy 클래스임을 명시  // name으로 인덱스 설정(잘 사용하지 않음)           // 테이블에 유니크 설정(제약사항)
//@Table(name="member", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})// catalog, name, schema를 지정할수있음 따로 설정하지 않으면 디폴트로 설정된다.
@EntityListeners(value = MyEntityListener.class)
public class Member implements Auditable{
    // 엔티티는 모두 컬럼으로 표현 해야함

    // generationType이란
    // IDENTITY --> mysql에서 사용되고 auto-Increment와 같다
    // SEQUENCE --> oracle,h2DB에서 사용
    // TABLE --> DB종류의 상관없이 아이디를 관리하는 별도의 테이블을 생성하여 관리
    // AUTO --> 지정하지 않으면 각 DB에 맞는 값으로 자동으로 넘겨줌
    @Id // pk는 필수로 필요하다.
    @GeneratedValue // 생성된 데이터를 사용하겠다.
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    // ENUM을 사용하는 경우 반드시 해당 어노테이션과, String값으로 저장되게 타입을 설정해야함
    // 해당 어노테이션을 붙이지 않는 경우 의도하지 않은 결과가 DB에 저장되거나 할수있기 때문임
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // @OneToMany(fetch = FetchType.EAGER)
    // private List<Address> address;

    // Entity의 Listener -->  일반적으로 현업에서는 prePersist, preUpdate를 가장 많이 사용함
    // @PrePersist
    // public void prePersist() {
        // @PrePersist --> insert 메서드가 실행되기 전에 실행
        // 리스너를 지정하지 않고 어노테이션만 사용하면 이런식으로 사용할수있음
        // 대표적으로는 서비스로직에서 개발자가 직접 날짜를 코딩하는것이 아닌
        // 이런식으로 데이터를 저장할때 자동으로 저장되게 세팅할수있음

        // System.out.println(">>> prePersist");
        // this.createdAt = LocalDateTime.now();
        // this.updateAt = LocalDateTime.now();
    // }

    @PostPersist
    public void postPersist() {
        // @PostPersist --> insert 메서드가 실행된 후 실행
        //  System.out.println(">>> postPersist");
    }

    // @PreUpdate
    // public void preUpdate() {
        // @PreUpdate -->  merge 메서드가 실행되기 전
    //     System.out.println(">>> preUpdate");
    //     this.updatedAt = LocalDateTime.now();
    // }

    @PostUpdate
    public void postUpdate() {
        // @PostUpdate --> merge 메서드가 실행된 후
        System.out.println(" >>> postUpdate");
    }

    @PreRemove
    public void preRemove() {
        // @PreRemove --> delete 메서드가 실행되기 전
        System.out.println(">>> preRemove");
    }

    @PostRemove
    public void postRemove() {
        // @PostRemove --> delete 메서드가 실행된 후
        System.out.println(">>> postRemove");
    }

    @PostLoad
    public void postLoad() {
        // @PostLoad --> select 조회가 실행된 직후에 실행
        System.out.println(">>> postLoad");
    }


}
