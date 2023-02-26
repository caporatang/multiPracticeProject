package com.multi.pratice.multipratice.springbasic.validation.validator;

import com.multi.pratice.multipratice.springbasic.validation.annotation.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.validation.validator
 * fileName : YearMonthValidator
 * author : taeil
 * date : 2023/02/26
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/26        taeil                   최초생성
 */
public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {
    // validation 클래스

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        // 초기화 메서드
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // yyyyMM
        try {
            LocalDate localDate = LocalDate.parse(value+"01", DateTimeFormatter.ofPattern(this.pattern));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}