package com.multi.pratice.multipratice.springbasic.interceptor.interceptorr;


import com.multi.pratice.multipratice.springbasic.interceptor.annotation.Auth;
import com.multi.pratice.multipratice.springbasic.interceptor.exception.NotNameMatchException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.interceptor.interceptorr
 * fileName : AuthInterceptor
 * author : taeil
 * date : 2023/02/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/28        taeil                   최초생성
 */
@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    // Interceptor에서 @Auth 어노테이션이 붙어있는 경우 session을 검사해서
    // session이 있으면 통과시키고, 아니면 불통!


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception
    {
        String url = request.getRequestURI();
        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();


        log.info("request url : {}", url);

        // 어노테이션 체크
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation : {}", hasAnnotation);


        // 나의 서버는 모두 public으로 동작한다고 가정
        // 단, Auth 권한을 가진 요청에 대해서는 세션 또는 쿠키, 뭔가 확인하는 로직을 추가함
        if (hasAnnotation) {
            // 간단하게 권한(?)을 체크해보자
            String query = uri.getQuery();
            if(query.equals("name=steve")) {
                log.info("interceptor name=steve");
                return true;
            }
            log.info("interceptor name=another");
            // name이 steve가 아니면 AuthException -> handler(GlobalExceptionHandler)가 받음 -> UNAUTHORIZED 익셉션 발생
            throw new NotNameMatchException();
        }

        return true;
    }


    private boolean checkAnnotation(Object handler, Class clazz) {
        // resource javascript, html -> resource에 대한 요청이면 패스
        if( handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        // annotation의 유무 체크
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if(null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)) {
            // @Auth 어노테이션을 가지고 있는 경우 true
            return true;
        }
        return false;
    }
}