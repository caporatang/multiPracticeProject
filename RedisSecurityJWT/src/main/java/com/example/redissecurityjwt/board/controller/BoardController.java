package com.example.redissecurityjwt.board.controller;

import com.example.redissecurityjwt.board.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : com.example.redissecurityjwt.board.controller
 * fileName : BoardController
 * author : taeil
 * date : 2023/03/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/28        taeil                   최초생성
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/board/v1/")
public class BoardController {

    private final BoardService boardService;


    @GetMapping("")
    public String boardGreeting() {
        return boardService.boardGreeting();
    }

}