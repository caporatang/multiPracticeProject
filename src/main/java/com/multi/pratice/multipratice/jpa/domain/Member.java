package com.multi.pratice.multipratice.jpa.domain;


import com.multi.pratice.multipratice.jpa.listener.Auditable;
import com.multi.pratice.multipratice.jpa.listener.MemberEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    // ID자동 생성 전략 -> mysql, maria autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

}
