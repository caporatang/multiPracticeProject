package com.example.redissecurityjwt.user.repository;

import com.example.redissecurityjwt.user.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.example.redissecurityjwt.user.repository
 * fileName : UserRoleJpaRepository
 * author : taeil
 * date : 2023/03/29
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/29        taeil                   최초생성
 */
public interface UserRoleJpaRepository extends JpaRepository<UserRole, Long> {
}