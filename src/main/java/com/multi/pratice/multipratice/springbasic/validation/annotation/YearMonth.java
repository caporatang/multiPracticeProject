package com.multi.pratice.multipratice.springbasic.validation.annotation;

import com.multi.pratice.multipratice.springbasic.validation.validator.YearMonthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = { YearMonthValidator.class }) // 어떤 클래스를 사용해서 validation을 검사할건데?
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface YearMonth {
    // email 어노테이션을 커스텀해보자

    // String message() default "{javax.validation.constraints.Email.message}";
    // 기본적으로 출력되는 메세지 커스텀
    String message() default "yyyyMM 형식에 맞지 않습니다";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String pattern() default "yyyyMMdd";
}
