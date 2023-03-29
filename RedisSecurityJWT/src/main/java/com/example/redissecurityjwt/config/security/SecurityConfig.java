package com.example.redissecurityjwt.config.security;

import com.example.redissecurityjwt.config.jwt.JwtCheckFilter;
import com.example.redissecurityjwt.config.jwt.JwtLoginFilter;
import com.example.redissecurityjwt.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * packageName : com.example.redissecurityjwt.config.security
 * fileName : SecurityCOnfig
 * author : taeil
 * date : 2023/03/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/28        taeil                   최초생성
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {

        JwtCheckFilter jwtCheckFilter = new JwtCheckFilter(userService, authenticationManager(authenticationConfiguration));
        JwtLoginFilter jwtLoginFilter = new JwtLoginFilter(authenticationManager(authenticationConfiguration));

         http.csrf().disable();
         http.authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/user/v1/**")).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/admin/v1/**")).hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()

                 .csrf().disable()
                 .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                 )
                 .addFilterAt(jwtLoginFilter, UsernamePasswordAuthenticationFilter.class)
                 .addFilterAt(jwtCheckFilter, BasicAuthenticationFilter.class);
         return http.build();
    } // method end

    @Bean
    RoleHierarchy roleHierarchy ()
    {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");
        return roleHierarchy;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


} // config end