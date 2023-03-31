package com.example.redissecurityjwt.board.domain;

import com.example.redissecurityjwt.user.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.boot.model.relational.Sequence;

import javax.persistence.*;

/**
 * packageName : com.example.redissecurityjwt.board.domain
 * fileName : Board
 * author : taeil
 * date : 2023/03/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/28        taeil                   최초생성
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}