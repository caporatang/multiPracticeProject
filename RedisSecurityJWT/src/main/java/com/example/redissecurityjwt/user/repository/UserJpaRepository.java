package com.example.redissecurityjwt.user.repository;

import com.example.redissecurityjwt.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
