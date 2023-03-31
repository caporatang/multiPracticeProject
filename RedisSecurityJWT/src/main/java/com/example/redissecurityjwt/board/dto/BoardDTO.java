package com.example.redissecurityjwt.board.dto;

import lombok.*;

/**
 * packageName : com.example.redissecurityjwt.board.dto
 * fileName : BoardDTO
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
public class BoardDTO {
    private Long userId;
    private Long boardId;
    private String title;
    private String content;
}