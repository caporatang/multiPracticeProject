package com.multi.pratice.multipratice.jpa.repository;

import com.multi.pratice.multipratice.jpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    // -> soft deleted select method
    List<Book> findAllByDeletedFalse();
    List<Book> findAllByDeletedTrue();
}
