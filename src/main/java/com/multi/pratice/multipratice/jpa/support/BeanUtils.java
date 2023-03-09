package com.multi.pratice.multipratice.jpa.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * packageName : com.multi.pratice.multipratice.jpa.support
 * fileName : BeanUtils
 * author : taeil
 * date : 2023/03/09
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/09        taeil                   최초생성
 */
@Component
public class BeanUtils implements ApplicationContextAware {
    // application context에서 bean을 가져올수있음
    // --> class에 Component를 붙이지 않아도 bean을 가져다가 쓸수있음

    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtils.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        // 클래스에 맞는 클래스를 리턴해줌
        return applicationContext.getBean(clazz);
    }


}