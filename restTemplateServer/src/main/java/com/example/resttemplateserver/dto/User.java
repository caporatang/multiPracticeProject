package com.example.resttemplateserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName : com.example.resttemplateserver.dto
 * fileName : User
 * author : taeil
 * date : 2023/03/03
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/03        taeil                   최초생성
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private int age;

}