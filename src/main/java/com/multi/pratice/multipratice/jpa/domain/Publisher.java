package com.multi.pratice.multipratice.jpa.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.multi.pratice.multipratice.jpa.domain
 * fileName : Publisher
 * author : taeil
 * date : 2023/03/11
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/11        taeil                   최초생성
 */
@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Publisher extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany // -> 하나의 출판사는 여러개의 책을 가질수있음, 하나의 출판사(one) to 여러개의 책(Many)
    @JoinColumn(name = "publisher_id")
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        this.books.add(book);
    }

}