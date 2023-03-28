package com.example.redissecurityjwt.board.service;

import com.example.redissecurityjwt.board.repository.BoardJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * packageName : com.example.redissecurityjwt.board.service
 * fileName : BoardService
 * author : taeil
 * date : 2023/03/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/28        taeil                   최초생성
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final BoardJpaRepository boardJpaRepository;

    public String boardGreeting() {
        return "보드 그리팅 메서드 호출";
    }

}