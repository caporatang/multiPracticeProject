package com.example.redissecurityjwt.board;

import com.example.redissecurityjwt.board.domain.Board;
import com.example.redissecurityjwt.board.dto.BoardDTO;
import com.example.redissecurityjwt.board.repository.BoardJpaRepository;
import com.example.redissecurityjwt.board.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * packageName : com.example.redissecurityjwt.board
 * fileName : BoardServiceTest
 * author : taeil
 * date : 2023/03/31
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/31        taeil                   최초생성
 */
@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardJpaRepository boardRepository;

//    @BeforeEach
//    public void before() {
//        boardRepository.deleteAll();
//    }


    @Test
    void boardInsertMockData() {
        BoardDTO boardDTO1 = new BoardDTO();
        BoardDTO boardDTO2 = new BoardDTO();
        BoardDTO boardDTO3 = new BoardDTO();

        for (int i = 0; i <= 5; i++) {
            boardDTO1.setBoardId((long) i);
            boardDTO1.setContent("나는 1번의 " + i + "번째 내용");
            boardDTO1.setTitle("나는 1번의" + i + "번째 제목");
            boardDTO1.setUserId(1L);
            boardService.writePost(boardDTO1);
        }
        for (int i = 6; i <= 11; i++) {
            boardDTO2.setBoardId((long) i);
            boardDTO2.setContent("나는 2번의 " + i + "번째 내용");
            boardDTO2.setTitle("나는 2번의" + i + "번째 제목");
            boardDTO2.setUserId(2L);
            boardService.writePost(boardDTO2);
        }

        for (int i = 11; i <= 15; i++) {
            boardDTO3.setBoardId((long) i);
            boardDTO3.setContent("나는 어드민이 작성한 " + i + "번째 내용");
            boardDTO3.setTitle("나는 어드민이 작성한 " + i + "번째 제목");
            boardDTO3.setUserId(3L);
            boardService.writePost(boardDTO3);
        }
    }


    @Test
    @DisplayName("저장된 게시글 조회")
    void boardList() {
        System.out.println(boardRepository.findAll());
        List<Board> board = boardRepository.findAll();
        System.out.println(board.get(0));
        System.out.println(board.get(0).getUser());
    }


}