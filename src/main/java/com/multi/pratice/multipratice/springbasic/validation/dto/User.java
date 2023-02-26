package com.multi.pratice.multipratice.springbasic.validation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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


}