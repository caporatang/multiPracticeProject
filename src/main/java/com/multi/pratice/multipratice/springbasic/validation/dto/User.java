package com.multi.pratice.multipratice.springbasic.validation.dto;

import com.multi.pratice.multipratice.springbasic.validation.annotation.YearMonth;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.validation.dto
 * fileName : User
 * author : taeil
 * date : 2023/02/26
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/26        taeil                   최초생성
 */
@Getter
@Setter
@ToString
public class User {
    // 모든 validation annotation은 message를 포함하고있음
    @NotBlank
    private String name;

    @Max(value = 90)
    private int age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxx ")
    private String phoneNumber;

    // 재정의한 annotation
    @YearMonth
    private String reqYearMonth; // yyyyMM

    // car 클래스에 validation 어노테이션을 붙였다고해도, 검증을 위해서는 꼭 User에서 valid어노테이션을 붙여야함
    @Valid
    private List<Car> cars;


    // @AssertTrue(message = "yyyyMM의 형식에 맞지 않습니다") // -> 재사용이 불가능함
    public boolean isReqYearMonthValidation() {
        // 리턴타입이 boolean인 경우 메서드 이름을 꼭 is를 붙여주어야함
        // 111111 이런식으로 들어왔을때의 날짜 검증

        // try {
        //  LocalDate localDate = LocalDate.parse(getReqYearMonth()+"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
        //  } catch (Exception e) {
        //      return false;
        //  }
        return true;
    }

}