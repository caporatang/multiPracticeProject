package com.example.redissecurityjwt.config.jwt;

import com.example.redissecurityjwt.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName : com.example.redissecurityjwt.config.jwt
 * fileName : JwtCheckFilter
 * author : taeil
 * date : 2023/03/30
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/30        taeil                   최초생성
 */

public class JwtCheckFilter extends BasicAuthenticationFilter {

    private UserService userService;

    public JwtCheckFilter(UserService userService, AuthenticationManager authenticationManager) {
        super(authenticationManager);
//    public JwtCheckFilter(AuthenticationManager authenticationManager, UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException
    {
        super.doFilterInternal(request, response, chain);
    }










} // class end