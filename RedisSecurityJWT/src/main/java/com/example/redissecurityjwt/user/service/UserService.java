package com.example.redissecurityjwt.user.service;

import com.example.redissecurityjwt.user.domain.User;
import com.example.redissecurityjwt.user.domain.UserRole;
import com.example.redissecurityjwt.user.dto.UserDTO;
import com.example.redissecurityjwt.user.repository.UserJpaRepository;
import com.example.redissecurityjwt.user.repository.UserRoleJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * packageName : com.example.redissecurityjwt.user.service
 * fileName : UserService
 * author : taeil
 * date : 2023/03/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/28        taeil                   최초생성
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userRepository;
    private final UserRoleJpaRepository userRoleRepository;
    private final ModelMapper modelMapper;
    public String testGreeting() {
        return "그리팅 메서드를 호출";
    }

    public Long insertMockData(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pwd = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(pwd);

        User saveUser = userRepository.save(user);
        addAuthority(saveUser.getId(), "ROLE_USER");
        return saveUser.getId();
    }

    public void addAuthority(Long userId, String authority) {
        userRepository.findById(userId).ifPresent(user -> {
            UserRole newRole = new UserRole(user.getId(), authority);
            userRoleRepository.save(newRole);
        });
    }


}