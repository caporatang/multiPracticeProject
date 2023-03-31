package com.example.redissecurityjwt.board.controller;

import com.example.redissecurityjwt.board.domain.Board;
import com.example.redissecurityjwt.board.dto.BoardDTO;
import com.example.redissecurityjwt.board.repository.BoardJpaRepository;
import com.example.redissecurityjwt.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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
@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/board/v1")
public class BoardController {

    private final BoardService boardService;

    @RequestMapping("/list")
    public String boardList(Model model, @RequestParam Long boardId) {
        log.info("boardId {}", boardId);
        List<BoardDTO> boardDTOList = boardService.boardList(boardId);
        model.addAttribute("boardList", boardDTOList);
        return "board";
    }

    @GetMapping("")
    public String moveBoard() {
        return "board";
    }


    @PostMapping("")
    public void writePost(BoardDTO boardDTO) {
        boardService.writePost(boardDTO);
    }

}