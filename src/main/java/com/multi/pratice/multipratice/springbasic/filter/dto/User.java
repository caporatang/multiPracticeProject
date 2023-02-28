package com.multi.pratice.multipratice.springbasic.filter.dto;

import lombok.*;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.filter.dto
 * fileName : User
 * author : taeil
 * date : 2023/02/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/28        taeil                   최초생성
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private int age;

}