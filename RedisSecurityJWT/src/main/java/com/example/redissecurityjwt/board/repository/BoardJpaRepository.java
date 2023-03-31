package com.example.redissecurityjwt.board.repository;

import com.example.redissecurityjwt.board.domain.Board;
import com.example.redissecurityjwt.board.dto.BoardDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardJpaRepository extends JpaRepository<Board, Long> {

}
