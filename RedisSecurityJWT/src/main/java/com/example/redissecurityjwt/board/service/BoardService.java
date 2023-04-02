package com.example.redissecurityjwt.board.service;

import com.example.redissecurityjwt.board.domain.Board;
import com.example.redissecurityjwt.board.dto.BoardDTO;
import com.example.redissecurityjwt.board.exception.BoardNotFoundException;
import com.example.redissecurityjwt.board.repository.BoardJpaRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Transactional
    @Cacheable(value = "Board", key = "#boardId", cacheManager = "cacheManager") // -> 단건 조회 cache
    public Board getBoard(Long boardId) {
        return boardJpaRepository.findById(boardId).orElseThrow(() -> new BoardNotFoundException("게시물 조회 결과가 없습니다."));
    }


    @CachePut(value = "Board", key = "#boardDTO", cacheManager = "cacheManager") // -> put cache
    public void writePost(BoardDTO boardDTO) {
        Board inDTO = modelMapper.map(boardDTO, Board.class);
        boardRepository.save(inDTO);
    }

    @Transactional
    @Cacheable(value = "Board", cacheManager = "cacheManager") // 전체 조회 cache
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

    @CacheEvict(value = "Board", key = "#boardId", cacheManager = "cacheManager")
    public void deletePost(Long boardId) {
        Board boardEntity = boardJpaRepository.findById(boardId).orElseThrow(() -> new BoardNotFoundException("게시물 조회 결과가 없습니다."));
        boardJpaRepository.delete(boardEntity);
    }



}