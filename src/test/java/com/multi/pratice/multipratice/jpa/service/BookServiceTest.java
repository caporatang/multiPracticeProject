package com.multi.pratice.multipratice.jpa.service;

import com.multi.pratice.multipratice.jpa.repository.BookRepository;
import com.multi.pratice.multipratice.jpa.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    @DisplayName("book transactional Test")
    void transactionTest() {
        // 메서드가 시작하는 시점이 트랜잭션 시작
        bookService.putBookAndPublisher();
        System.out.println("book --> " + bookRepository.findAll());
        System.out.println("publisher --> " + publisherRepository.findAll());

    }

}