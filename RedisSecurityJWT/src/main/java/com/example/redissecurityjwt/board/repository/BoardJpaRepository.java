package com.example.redissecurityjwt.board.repository;

import com.example.redissecurityjwt.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<Board, Long> {
}
