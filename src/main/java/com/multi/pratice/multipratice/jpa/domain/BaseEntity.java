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

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;


}