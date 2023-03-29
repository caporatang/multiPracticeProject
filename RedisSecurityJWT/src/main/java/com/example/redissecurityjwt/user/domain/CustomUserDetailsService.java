package com.example.redissecurityjwt.user.domain;

import com.example.redissecurityjwt.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName : com.example.redissecurityjwt.user.domain
 * fileName : CustomUserDetailsService
 * author : taeil
 * date : 2023/03/29
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/29        taeil                   최초생성
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserJpaRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String userEmail) {
        // DB에 있는지 조회 후,
        return userRepository.findByEmail(userEmail)
                .map(user -> createUserDetail(userEmail, user)) // UserDetail 객체 리턴
                .orElseThrow(() -> new UsernameNotFoundException("Email: " + userEmail + " not found"));
    }

    private org.springframework.security.core.userdetails.User createUserDetail(String username, User user) {
        // UserDetail 객체를 만들어서 리턴
        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                grantedAuthorities);
    }
}