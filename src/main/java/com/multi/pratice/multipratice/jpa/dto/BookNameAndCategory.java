package com.multi.pratice.multipratice.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName : com.multi.pratice.multipratice.jpa.dto
 * fileName : BookNameAndCategory
 * author : taeil
 * date : 2023/04/05
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/05        taeil                   최초생성
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookNameAndCategory {

    private String name;
    private String category;
}