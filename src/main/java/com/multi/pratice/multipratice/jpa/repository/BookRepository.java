package com.multi.pratice.multipratice.jpa.repository;

import com.multi.pratice.multipratice.jpa.domain.Book;
import com.multi.pratice.multipratice.jpa.dto.BookNameAndCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    // -> soft deleted select method
    List<Book> findAllByDeletedFalse();
    List<Book> findAllByDeletedTrue();

    // @Query 사용해야 하는 이유
    List<Book> findByNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(String name, LocalDateTime createAt, LocalDateTime updatedAt);

    // JPQL -> Entity를 기반으로 하는 쿼리를 생성하는것이다.
    // JPQL의 장점 -> dialect(DB의 종류에 따라 쿼리를 생성해줌)

    // 파라메터 매핑 방법
    // ?1 ?2 ?3 파라메터를 쿼리와 매핑시키는 방법이다 -> 꼭 순차적으로 1 2 3 으로 사용할 필요는 없다(파라메터가 추가될 경우 사이드이펙트 발생).
    //@Query(value = "select b from Book b "
    //         + "where name = ?1 and createdAt >= ?2 and updatedAt >= ?3")
    // -> 권장하는 방법 : name을 기준으로 매핑하는것이 좋음 -> 사이드이펙트 방지, 재활용 용이
    @Query(value = "select b from Book b "
            + "where name = :name and createdAt >= :createdAt and updatedAt >= :updatedAt")
    List<Book> findByNameRecently(@Param("name") String name,
                                 @Param("createdAt") LocalDateTime createdAt,
                                 @Param("updatedAt") LocalDateTime updatedAt);

    @Query(value = "select b.name as name, b.category as category from Book b")
    List<Tuple> findBookNameAndCategory();


}
