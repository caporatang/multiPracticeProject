package com.multi.pratice.multipratice.jpa.service;

import com.multi.pratice.multipratice.jpa.domain.Book;
import com.multi.pratice.multipratice.jpa.domain.Publisher;
import com.multi.pratice.multipratice.jpa.repository.BookRepository;
import com.multi.pratice.multipratice.jpa.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName : com.multi.pratice.multipratice.jpa.service
 * fileName : BookService
 * author : taeil
 * date : 2023/03/20
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/20        taeil                   최초생성
 */
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Transactional
    public void putBookAndPublisher() {
        // 메서드에 트랜잭션을 걸지 않으면
        // 메서드 내부의 2개의 세이브는 각각 다른 트랜잭션을 타게 된다
        Book book = new Book();
        book.setName("나는 책이야");

        bookRepository.save(book);

        Publisher publisher = new Publisher();
        publisher.setName("나는 책이야의 저자입니다");
        publisherRepository.save(publisher);

    }





}