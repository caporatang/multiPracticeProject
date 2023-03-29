package com.example.redissecurityjwt.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
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
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
//        return http.
//                authorizeRequests()
//                .antMatchers("/", "/board/v1/**", "/user/v1/**").permitAll()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();


         http.csrf().disable();
         http.authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/user/v1/**")).hasAnyRole("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/admin/v1/**")).hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin();

         return http.build();


                // .csrf().disable()
                // .sessionManagement(session ->
                //        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // );
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

} // config end