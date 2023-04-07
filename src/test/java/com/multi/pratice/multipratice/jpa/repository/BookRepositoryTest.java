package com.multi.pratice.multipratice.jpa.repository;

import com.multi.pratice.multipratice.jpa.domain.Book;
import com.multi.pratice.multipratice.jpa.domain.Member;
import com.multi.pratice.multipratice.jpa.domain.Publisher;
import com.multi.pratice.multipratice.jpa.domain.Review;
import com.multi.pratice.multipratice.jpa.dto.BookStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;

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
    void queryTest() {
        bookRepository.findAll().forEach(System.out::println);
        System.out.println("findByNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual : "
                + bookRepository.findByNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(
                        "JPA 111",
                LocalDateTime.now().minusDays(1L),
                LocalDateTime.now().minusDays(1L)
        ));

        System.out.println("findByRecently : "
                + bookRepository.findByNameRecently("JPA 111"
                    , LocalDateTime.now().minusDays(1L)
                    , LocalDateTime.now().minusDays(1L)));

        System.out.println("나는 bookCategory" + bookRepository.findBookNameAndCategory());

        // class로 객체를 만들어서 리턴 타입을 지정하는 경우 tuple에 저장이 되게 되어있다.
        // 따로 원하는 데이터만 뽑아서 처리해야할 일이 있다면, DTO처럼 객체를 만들지말고, interface를 만들어서 가지고 오자
        //bookRepository.findBookNameAndCategory().forEach(tuple -> {
        //    System.out.println(tuple.get(0) + " " + tuple.get(1));
        //});
        bookRepository.findBookNameAndCategory().forEach(b -> {
            System.out.println(b.getName() + " " + b.getCategory());
        });

        bookRepository.findBookNameAndCategory(PageRequest.of(1,1)).forEach(
                bookNameAndCategory -> System.out.println(bookNameAndCategory.getCategory() + " : "+ bookNameAndCategory.getName())
        );

        bookRepository.findBookNameAndCategory(PageRequest.of(0,1)).forEach(
                bookNameAndCategory -> System.out.println(bookNameAndCategory.getCategory() + " : "+ bookNameAndCategory.getName())
        );
    }

    @Test
    void nativeQueryTest() {
        // 일반적인 findAll -> where절이 붙음
        // bookRepository.findAll().forEach(System.out::println);
        // nativeQuery -> Entity에 작성한 @Where을 무시한 select * from 쿼리가 발생
        // bookRepository.findAllCustom().forEach(System.out::println);

        List<Book> books = bookRepository.findAll();
        for(Book book : books) {
            book.setCategory("IT책임");
        }
        bookRepository.saveAll(books); // -> 하나하나 아이디값으로 update 쿼리를 날림 -> 데이터가 많은 경우 성능 이슈가 발생
        System.out.println(bookRepository.findAll());

        System.out.println("update rows : " + bookRepository.updateCategories());
        bookRepository.findAllCustom().forEach(System.out::println);

        System.out.println(bookRepository.showTables());
    }

    @Test
    void converterTest() {
        bookRepository.findAll().forEach(System.out::println);

        Book book = new Book();
        book.setName("다른 IT전문서적");
        book.setStatus(new BookStatus(200));
        bookRepository.save(book);

        System.out.println(bookRepository.findRawRecord().values());
    }

    @Test
    void bookCascadeTest() {
        // 영속성 전이 -> 결과적으로 좀 더 객체에 집중 할 수 있게 해주는 것 -> 객체 하나씩 영속성에 매번 등록해주지 않아도 된다.
        Book book = new Book();
        book.setName("나는 책");

        Publisher publisher = new Publisher();
        publisher.setName("나는 출판사 이름");

        book.setPublisher(publisher);
        bookRepository.save(book);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publisher : " + publisherRepository.findAll());

        Book book1 = bookRepository.findById(1L).get();
        book1.getPublisher().setName("나는 변경된 출판사 이름");
        bookRepository.save(book1);

        System.out.println("publisher : " + publisherRepository.findAll());


        Book book2 = bookRepository.findById(1L).get();
        // bookRepository.delete(book2);
        // publisherRepository.delete(book2.getPublisher());

        Book book3 = bookRepository.findById(1L).get();
        book3.setPublisher(null);
        bookRepository.save(book3);


        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());
        System.out.println("book3-publisher : " + bookRepository.findById(1L).get().getPublisher());
    }

    @Test
    void bookRemoveCascadeTest() {
        bookRepository.deleteById(1L);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers " + publisherRepository.findAll());

        bookRepository.findAll().forEach(book -> System.out.println(book.getPublisher()));
    }

    @Test
    void softDelete() {
        bookRepository.findAll().forEach(System.out::println);
        System.out.println(bookRepository.findById(3L));

        // where 어노테이션 사용 전 -> DB는 true false로 구분하지 않는다. 0 -> false, 1 -> true
        // bookRepository.findAllByDeletedFalse().forEach(System.out::println);
        // bookRepository.findAllByDeletedTrue().forEach(System.out::println);
    }

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