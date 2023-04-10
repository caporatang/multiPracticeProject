package com.multi.pratice.multipratice.jpa.service;

import com.multi.pratice.multipratice.jpa.domain.Comment;
import com.multi.pratice.multipratice.jpa.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {
    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void commentTest() {
        commentService.init();
        // commentRepository.findAll().forEach(System.out::println);

        // -> comment 테이블에 있는 전체 컬럼에 대한 업데이트가 실행된다
        // update
        //         comment
        // set
        // updated_at=?,
        // comment=?,
        // commented_at=?,
        // review_id=?
        // where
        // id=?
        commentService.updateSomething();

        // commentService.insertSomething();

    }



}