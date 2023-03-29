package com.example.redissecurityjwt.config.jwt;

import lombok.*;

/**
 * packageName : com.example.redissecurityjwt.config.jwt
 * fileName : VerifyResult
 * author : taeil
 * date : 2023/03/30
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/30        taeil                   최초생성
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class VerifyResult {
    private boolean success;
    private String memberId;
}