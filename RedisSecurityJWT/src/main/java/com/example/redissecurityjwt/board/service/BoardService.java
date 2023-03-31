package com.example.redissecurityjwt.board.service;

import com.example.redissecurityjwt.board.domain.Board;
import com.example.redissecurityjwt.board.dto.BoardDTO;
import com.example.redissecurityjwt.board.repository.BoardJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private final ModelMapper modelMapper;
    private final BoardJpaRepository boardRepository;

    public void writePost(BoardDTO boardDTO) {
        Board inDTO = modelMapper.map(boardDTO, Board.class);
        boardRepository.save(inDTO);
    }

    @Transactional
    public List<BoardDTO> boardList(Long boardId) {
        List<Board> boards = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();

        for (Board board : boards) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .boardId(board.getBoardId())
                    .userId(board.getUser().getUserId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .build();
            boardDTOList.add(boardDTO);
        }
        return boardDTOList;
    }

}