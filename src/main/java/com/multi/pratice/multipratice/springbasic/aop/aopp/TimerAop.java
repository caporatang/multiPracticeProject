package com.multi.pratice.multipratice.springbasic.aop.aopp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.aop.aopp
 * fileName : TimerAop
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
public class TimerAop {
    // @Bean과 @Component의 차이
    // Bean은 클래스에 붙일수 없음, @configuration을 붙이고 메서드 단위로 여러개의 bean을 정의할수있음

    // 메서드의 실행 시간 같은걸 측정할수있음
    @Pointcut("execution(* com.multi.pratice.multipratice.springbasic.aop.controller..*.*(..))")
    private void cut() {}

    // 정의한 어노테이션 경로
    @Pointcut("@annotation(com.multi.pratice.multipratice.springbasic.aop.annotation.Timer)")
    private void enableTimer() {}

    // before, after를 동시에 제어해야 시간을 측정할수있음
    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        // 메서드 시작 (before)
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 실행되는 메서드에서 리턴이 되면 (리턴 데이터가 있으면), Object로 리턴이 됨.
        // void인 경우에는 리턴이 없음
        Object result = joinPoint.proceed(); // --> procced가 메서드 실행임

        // after
        stopWatch.stop();

        System.out.println("total time " + stopWatch.getTotalTimeSeconds());

    }







}