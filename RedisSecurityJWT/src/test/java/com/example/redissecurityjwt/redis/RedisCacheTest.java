package com.example.redissecurityjwt.redis;

import com.example.redissecurityjwt.board.domain.Board;
import com.example.redissecurityjwt.board.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName : com.example.redissecurityjwt.redis
 * fileName : RedisCacheTest
 * author : taeil
 * date : 2023/04/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/02        taeil                   최초생성
 */
@SpringBootTest
public class RedisCacheTest {

    @Autowired
    private BoardService boardService;

    @Test
    @Transactional
    @DisplayName("단건 조회 cache테스트 -> 조회 시 쿼리가 Request한 만큼 찍히지 않는다면 cache 사용중")
    void getBoard() {
        System.out.println(boardService.getBoard(2L));
        System.out.println(boardService.getBoard(2L));
        System.out.println(boardService.getBoard(2L));
        System.out.println(boardService.getBoard(2L));
    }

}