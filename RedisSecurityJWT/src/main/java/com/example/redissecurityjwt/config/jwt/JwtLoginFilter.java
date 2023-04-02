package com.example.redissecurityjwt.config.jwt;

import com.example.redissecurityjwt.user.domain.User;
import com.example.redissecurityjwt.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName : com.example.redissecurityjwt.config.jwt
 * fileName : JwtLoginFilter
 * author : taeil
 * date : 2023/03/30
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/30        taeil                   최초생성
 */
@Transactional
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private ObjectMapper objectMapper = new ObjectMapper();

    public JwtLoginFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        setFilterProcessesUrl("/user/v1/login");
    }

    @SneakyThrows
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException
    {
       User user = objectMapper.readValue(request.getInputStream(), User.class);

       // userdetails 처리
       UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
               user.getEmail(), user.getPassword(), null
       );
       return getAuthenticationManager().authenticate(token); // -> 인증요청
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException
    {
//        User user = (User) authResult.getPrincipal();
        UserDetails user = (UserDetails) authResult.getPrincipal();

        // testOnly --> body에 이메일까지 담아서 가기
        User userEntity = new User();
        userEntity.setEmail(user.getUsername());

        response.setHeader(HttpHeaders.AUTHORIZATION, "Bearer "+ JwtUtil.makeAuthToken(user));
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        response.getOutputStream().write(objectMapper.writeValueAsBytes(userEntity));
    }








} // class end