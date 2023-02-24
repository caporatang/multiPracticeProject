package com.multi.pratice.multipratice.springbasic.aop.aopp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.aop.aopp
 * fileName : ParameterAop
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
public class ParameterAop {
    // point cut : 어느 부분에 적용시킬지.. 연산수식이 많음

    // aop 패키지 안에 컨트롤러 안에 있는 모든 메서드에 적용할거야.
    @Pointcut("execution(* com.multi.pratice.multipratice.springbasic.aop.controller..*.*(..))")
    private void cut() {}

    @Before("cut()") // --> cut이 실행되는 시점에 before때 이 메서드를 실행해
    public void before(JoinPoint joinPoint) {

        // 실행되는 메서드 이름 가져오기
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs(); // 메서드에 들어가고있는 arguments 즉 매개변수들의 배열
        for (Object obj : args ) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj") // cut메서드가 정상 실행되고 난 후, 리턴값을 알려줘.
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("return obj");
        System.out.println(returnObj);
    }

}