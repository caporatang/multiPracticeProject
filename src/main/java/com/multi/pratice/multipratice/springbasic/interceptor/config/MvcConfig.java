package com.multi.pratice.multipratice.springbasic.interceptor.config;

import com.multi.pratice.multipratice.springbasic.interceptor.interceptorr.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.interceptor.config
 * fileName : MvcConfig
 * author : taeil
 * date : 2023/02/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/28        taeil                   최초생성
 */
@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {
    // 만든 AuthInterceptor를 '등록'해서 사용해보자
    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // /api/private/*에 대해서만 인터셉터를 적용하고 검사할거야
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");
    }
}