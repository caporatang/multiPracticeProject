package com.example.redissecurityjwt.user.repository;

import com.example.redissecurityjwt.user.domain.User;
import com.example.redissecurityjwt.user.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
