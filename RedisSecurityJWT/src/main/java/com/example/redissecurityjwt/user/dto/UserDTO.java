package com.example.redissecurityjwt.user.dto;

import lombok.*;

/**
 * packageName : com.example.redissecurityjwt.user.dto
 * fileName : MemberDTO
 * author : taeil
 * date : 2023/03/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/28        taeil                   최초생성
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long userId;
    private String email;
    private String password;
}