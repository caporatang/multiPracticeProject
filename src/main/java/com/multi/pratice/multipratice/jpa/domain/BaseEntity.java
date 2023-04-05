package com.multi.pratice.multipratice.jpa.domain;

import com.multi.pratice.multipratice.jpa.listener.Auditable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * packageName : com.multi.pratice.multipratice.jpa.domain
 * fileName : BaseEntity
 * author : taeil
 * date : 2023/03/09
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/09        taeil                   최초생성
 */
@Getter
@Setter
@ToString
@EntityListeners(value = AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity implements Auditable {
    // columnDefinition은 잘 사용하지 않음 --> data.sql 에서 데이터를 넣을때 LocalDateTime을 default값으로 넣어줄수있음

    @CreatedDate
    // createdAt updatedAt은 BaseTimeEntity를 타지 않아, created, updated에 null이 찍힘, column의 default값을 설정하는 어노테이션
    // @Column(columnDefinition = "datetime(6), default now(6)" comment '생성시간', nullable = false, updatable = false)
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    // @Column(columnDefinition = "datetime(6), default now(6)" comment '수정시간', nullable = false)
    @Column(nullable = false)
    private LocalDateTime updatedAt;


}