package com.multi.pratice.multipratice.springbasic.junit.springjunit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.junit.springjunit.dto
 * fileName : Req
 * author : taeil
 * date : 2023/03/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/02        taeil                   최초생성
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Req {
    private int x;
    private int y;
}