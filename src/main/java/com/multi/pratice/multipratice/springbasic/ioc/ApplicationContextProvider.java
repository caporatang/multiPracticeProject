package com.multi.pratice.multipratice.springbasic.ioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.ioc
 * fileName : ApplicationContextProvider
 * author : taeil
 * date : 2023/02/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/23        taeil                   최초생성
 */
@Component
public class ApplicationContextProvider implements ApplicationContextAware {
    // componet 어노테이션으로, 해당 객체를 스프링에게 관리를 요청하면,
    // 해당 클래스로 스프링 컨테이너에서 관리되는 객체에 접근할수있음.

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }



}