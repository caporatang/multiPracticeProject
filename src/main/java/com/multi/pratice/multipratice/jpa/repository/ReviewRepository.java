package com.multi.pratice.multipratice.jpa.repository;

import com.multi.pratice.multipratice.jpa.domain.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // N + 1 해결 방법 중 하나 -> @Query로 쿼리 커스텀 하기

    // distinct -> cross join 발생으로 리뷰에 따라 결과값이 출력이 되서 등록된 리뷰가 세개인것처럼 출력된다, 중복값을 없애서 1번 리뷰에 코멘트는 1라인으로 출력
    @Query("select distinct r from Review r join fetch r.comments")
    List<Review> findAllByFetchJoin();

    // N + 1 해결 방법 중 하나 -> entityGraph 사용
    // @EntityGraph는 Data JPA에서 fetch 조인을 어노테이션으로 사용할 수 있도록 만들어 준 기능임.
    @EntityGraph(attributePaths = "comments")
    @Query("select r from Review r") // -> findAll과 동일한 쿼리
    List<Review> findAllEntityGraph();

    @EntityGraph(attributePaths = "comments") //-> query method에도 동일하게 적용 가능하다
    List<Review> findAll();

}
