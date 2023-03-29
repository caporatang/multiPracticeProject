package com.example.redissecurityjwt.user.service;

import com.example.redissecurityjwt.user.domain.UserRole;
import com.example.redissecurityjwt.user.repository.UserJpaRepository;
import com.example.redissecurityjwt.user.repository.UserRoleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName : com.example.redissecurityjwt.user.service
 * fileName : UserRoleService
 * author : taeil
 * date : 2023/03/30
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/30        taeil                   최초생성
 */
@Service
@RequiredArgsConstructor
public class UserRoleService {

    private final UserJpaRepository userRepository;
    private final UserRoleJpaRepository userRoleRepository;

    public void addAuthority(Long userId, String authority) {
        userRepository.findById(userId).ifPresent(user -> {
            UserRole newRole = new UserRole(user.getId(), authority);
            userRoleRepository.save(newRole);
        });
    }


}