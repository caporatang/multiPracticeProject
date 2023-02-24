package com.multi.pratice.multipratice.springbasic.aop.aopp;

import com.multi.pratice.multipratice.springbasic.aop.dto.User;
import com.multi.pratice.multipratice.springbasic.ioc.Base64Encoder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.aop.aopp
 * fileName : DecodeAop
 * author : taeil
 * date : 2023/02/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/24        taeil                   최초생성
 */
@Aspect
@Component
public class DecodeAop {
 // 데이터를 중간에 만지는일은 잘 없지만, 암호화라던지.. 특정한 경우에 사용될수있음
    @Pointcut("execution(* com.multi.pratice.multipratice.springbasic.aop.controller..*.*(..))")
    private void cut() {}

    @Pointcut("@annotation(com.multi.pratice.multipratice.springbasic.aop.annotation.Decode)")
    private void enableDecode() {}

    // 들어올땐 디코드, 나갈땐 인코딩 처리를 해서 내보내자
    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        // method에서 받는 매개변수(arguments)를 찾아오자
        Object[] args = joinPoint.getArgs();

        for(Object arg : args) {
            if(arg instanceof User) {  // 넘어온 인스턴스가 유저라면
                User user = User.class.cast(arg); // 유저로 형변환
                String base64Email = user.getEmail(); // 인코딩 이메일을 꺼내옴
                String email = new String (Base64.getDecoder().decode(base64Email), "UTF-8"); // 디코딩처리
                user.setEmail(email); // 디코딩 된 이메일을 User에 세팅해서 보냄
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {

        if(returnObj instanceof User) {

            User user = User.class.cast(returnObj);
            String email = user.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());

            user.setEmail(base64Email);
        }
    }
}