package com.multi.pratice.multipratice.jpa.repository;

import com.multi.pratice.multipratice.jpa.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.multi.pratice.multipratice.jpa.repository
 * fileName : CommentRepository
 * author : taeil
 * date : 2023/04/10
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/10        taeil                   최초생성
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}