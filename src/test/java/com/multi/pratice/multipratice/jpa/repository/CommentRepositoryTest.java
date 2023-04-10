package com.multi.pratice.multipratice.jpa.repository;

import com.multi.pratice.multipratice.jpa.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

/**
 * packageName : com.multi.pratice.multipratice.jpa.repository
 * fileName : CommentRepositoryTest
 * author : taeil
 * date : 2023/04/10
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/10        taeil                   최초생성
 */
@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    void commentTimeTest() {
        Comment comment = commentRepository.findById(3L).get();
        comment.setComment("LocalDatetime 시간을 테스트 해보자");
        comment.setCommentedAt(LocalDateTime.now());

        // 클리어 이전 데이터 : commentedAt=2023-04-10T22:25:44.877774
        System.out.println("나는 클리어 이전 데이터 :" + comment);

        commentRepository.saveAndFlush(comment);

        entityManager.clear();

        // clear -> 클리어 하고 난 후에는 DB의 데이터를 가지고 오기 때문에 초단위 까지만 출력이 된다.
        // commentedAt=2023-04-10T22:25:45 -> 컬럼의 값을 datetime(6)으로 설정하지 않았기 떄문에 실제 데이터베이스의 데이터는 이 값이다.
        System.out.println(commentRepository.findById(3L).get());

        // 영속성 컨텍스트의 데이터와, 실제 DB값이 틀어질수있다. -> 동일성이 일치하지 않을수있음
    }



}