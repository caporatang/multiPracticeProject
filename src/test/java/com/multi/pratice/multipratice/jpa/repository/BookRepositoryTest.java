package com.multi.pratice.multipratice.jpa.repository;

import com.multi.pratice.multipratice.jpa.domain.Book;
import com.multi.pratice.multipratice.jpa.domain.Member;
import com.multi.pratice.multipratice.jpa.domain.Publisher;
import com.multi.pratice.multipratice.jpa.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName : com.multi.pratice.multipratice.jpa.repository
 * fileName : BookRepositoryTest
 * author : taeil
 * date : 2023/03/09
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/09        taeil                   최초생성
 */
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MemberRepository memberRepository;



    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("JPA 어려워");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        bookRepository.save(book);
        System.out.println(bookRepository.findAll());

    }

    @Test
    @Transactional
    void bookRelationTest() {
        givenBookAndReview();

        Member member = memberRepository.findByEmail("taeil@naver.com");

        System.out.println("main method member : >>> " + member);

        System.out.println("Review : " + member.getReviews());
        System.out.println("Book : " + member.getReviews().get(0).getBook());
        System.out.println("Publisher :" + member.getReviews().get(0).getBook().getPublisher());
    }

    private void givenBookAndReview() {
        givenReview(givenMember(), givenBook(givenPublisher()));
    }

    private Member givenMember() {
        Member result = memberRepository.findByEmail("taeil@naver.com");
        System.out.println("given member : >>> " + result);
        return result;
    }

    private void givenReview(Member member, Book book) {
        Review review = new Review();
        review.setTitle("나는 제목");
        review.setContent("나는 리뷰 내용");
        review.setScore(5.0f);
        review.setMember(member);
        review.setBook(book);

        Review review1 = reviewRepository.save(review);
        System.out.println("Review : >>> " + review1);
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("JPA 어려워");
        book.setPublisher(publisher);

        Book book1 = bookRepository.save(book);

        System.out.println("Book : >> " + book1);
        return book1;
    }

    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("jpa 어려워 출판사");

        Publisher publisher1 = publisherRepository.save(publisher);
        System.out.println("Publisher : >>> " + publisher1);
        return publisher1;
    }

}