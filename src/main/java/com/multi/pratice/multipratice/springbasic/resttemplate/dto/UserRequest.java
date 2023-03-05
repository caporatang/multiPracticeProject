package com.multi.pratice.multipratice.springbasic.resttemplate.dto;

import lombok.*;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.resttemplate.dto
 * fileName : UserResponse
 * author : taeil
 * date : 2023/03/03
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/03        taeil                   최초생성
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String name;
    private int age;

}