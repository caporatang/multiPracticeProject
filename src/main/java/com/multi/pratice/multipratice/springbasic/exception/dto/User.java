package com.multi.pratice.multipratice.springbasic.exception.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.exception.dto
 * fileName : User
 * author : taeil
 * date : 2023/02/27
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/27        taeil                   최초생성
 */
@Getter
@Setter
@ToString
public class User {

    @NotEmpty
    @Size(min = 1, max = 10)
    private String name;

    @Min(1)
    @NotNull
    private Integer age;

}