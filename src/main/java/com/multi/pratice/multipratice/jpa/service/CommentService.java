package com.multi.pratice.multipratice.jpa.service;

import com.multi.pratice.multipratice.jpa.domain.Comment;
import com.multi.pratice.multipratice.jpa.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * packageName : com.multi.pratice.multipratice.jpa.service
 * fileName : CommentService
 * author : taeil
 * date : 2023/04/10
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/10        taeil                   최초생성
 */
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public void init() {
        for(int i = 0; i < 10; i++) {
            Comment comment = new Comment();
            comment.setComment("테스트 데이터 생성 : " + i);

            commentRepository.save(comment);
        }
    }

    // 일반적인 transactional 은 더티체킹 때문에 성능적인 이슈가 있을 수 있고, 사이드이펙트가 발생 될 수 있음
    // 내부적으로 SimpleJpaRepository 에 @Transactional(readOnly = true)이 설정 되어있음 -> find 계열 메서드 쿼리
    // 나머지 @Transactional은 method scope에 적용 되어있음 -> save update 계열 메서드 쿼리
    @Transactional(readOnly = true) // dirty 체크 스킵하고 처리하는 방법 readOnly = true
    public void updateSomething() {
        List<Comment> comments = commentRepository.findAll();

        // transactional 어노테이션을 사용하지 않으면, findAll을 하고 영속성 컨텍스트에 대한 관리가 끝이남 -> 아래의 for문에 대한 더티체킹이 발생되지 않는다.

        for(Comment comment : comments) {
            comment.setComment("더미 데이터 업데이트");
            // save 처리를 하지 않아도 update쿼리가 발생된다 -> 더티체킹
            // commentRepository.save(comment);
        }
    }

    @Transactional
    public void insertSomething() {
        // 새로 객체를 생성해서 넣는 경우에도 영속성 컨텍스트의 관리 대상이 되지 않는다. -> repo.save를 해주어야한다
        Comment comment = new Comment();
        comment.setComment("이건 뭐죠 ?");

        commentRepository.save(comment);

        Comment comment1 = commentRepository.findById(1L).get();
        comment1.setComment("나는 더티 체크 테스트입니다");
        System.out.println("더티 체크 엔티티 1번 : " + comment1.getComment());
    }

}