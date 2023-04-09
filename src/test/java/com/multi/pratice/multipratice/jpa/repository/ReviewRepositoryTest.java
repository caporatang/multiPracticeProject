package com.multi.pratice.multipratice.jpa.repository;

import com.multi.pratice.multipratice.jpa.domain.Review;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * packageName : com.multi.pratice.multipratice.jpa.repository
 * fileName : ReviewRepositoryTest
 * author : taeil
 * date : 2023/04/09
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/09        taeil                   최초생성
 */
@SpringBootTest
@Slf4j
public class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @Transactional
    void reviewTest() {
        // Eager인 경우 review 테이블을 조회하는 시점에 comment를 전부 조회 -> 조회를 한번에 하고 출력하는 경우에 영속성 컨텍스트의 1차 캐시에서 데이터를 뿌려줌

        List<Review> reviews = reviewRepository.findAll();
        // System.out.println(reviews);

        log.info("----- 전체 데이터 가져옴 -----");

        log.info("reviews.get(0), {}", reviews.get(0).getComments()); // -> Lazy인 경우 getComments를 할때마다 id에 해당하는 조회 쿼리를 실행

        log.info("----- 첫번째 리뷰의 코멘트 ------");

        log.info("reviews.get(1), {}", reviews.get(1).getComments());

        log.info("----- 두번째 리뷰의 코멘트 ------");

    }

    @Test
    @DisplayName("커스텀 쿼리로 fetch join 테스트")
    void customQuery() {
        // select 쿼리에 join이 걸려서 comments까지 함께 가져옴
        // from
        //  review review0_
        // inner join
        //  comment comments1_
        //      on review0_.id=comments1_.review_id
        List<Review> reviews = reviewRepository.findAllByFetchJoin();

        log.info("----- 전체 데이터 가져옴 -----");

        log.info("reviews.get(0), {}", reviews.get(0).getComments()); // -> Lazy인 경우 getComments를 할때마다 id에 해당하는 조회 쿼리를 실행

        log.info("----- 첫번째 리뷰의 코멘트 ------");

        log.info("reviews.get(1), {}", reviews.get(1).getComments());

        log.info("----- 두번째 리뷰의 코멘트 ------");

        reviews.forEach(System.out::println);
    }

    @Test
    @DisplayName("entityGraph test")
    void entityGraphTest() {
        List<Review> reviews = reviewRepository.findAllEntityGraph();
        reviews.forEach(System.out::println);

        List<Review> findAllReviews = reviewRepository.findAll();
        findAllReviews.forEach(System.out::println);
    }


}