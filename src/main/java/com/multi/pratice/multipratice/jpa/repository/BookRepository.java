package com.multi.pratice.multipratice.jpa.repository;

import com.multi.pratice.multipratice.jpa.domain.Book;
import com.multi.pratice.multipratice.jpa.dto.BookNameAndCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.awt.print.Pageable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

    // 일반적으로 Entity가 리턴 타입이 아니고, 원하는 컬럼들만 추려서 데이터를 뽑아와야 하는 경우
    // 아래처럼 사용하는 경우에 tuple 타입으로 저장이 된다. -> tuple로 필요해서 가지고 오는게 아니라면 DTO처럼 클래스가 아니라 interface로 선언해서 가지고 오자
//    @Query(value = "select b.name as name, b.category as category from Book b")
//    List<Tuple> findBookNameAndCategory();

    // 그냥 클래스로 가지고 오고 싶은 경우라면 객체를 쿼리에서 바로 생성해서 사용할수있음
    @Query(value = "select new com.multi.pratice.multipratice.jpa.dto.BookNameAndCategory(b.name, b.category) from Book b")
    List<BookNameAndCategory> findBookNameAndCategory();

    // @Query로 page 사용 해보기
    @Query(value = "select new com.multi.pratice.multipratice.jpa.dto.BookNameAndCategory(b.name, b.category) from Book b")
    Page<BookNameAndCategory> findBookNameAndCategory(PageRequest pageRequest);


    // native query는 Entity속성을 사용하지 못함 -> 스몰 book
    @Query(value = "select * from book", nativeQuery = true)
    List<Book> findAllCustom();

    // spring 공식 문서에서는 트랜잭셔널은 구체 클래스에서 사용하도록 권장 하고 있음
    // jpa는 인터페이스를 기반으로 한 프록시이므로 사용해도 괜찮다. -> 사용하는 메서드에서 붙여도 상관은 없음
    @Transactional // native 쿼리 사용시 트랜잭셔널을 직접 선언해주어야함 -> jpa에서 제공되는 save, update등은 내부적으로 @트랜잭셔널이 선언이 되어있음
    @Modifying // update 라는 것을 표기
    @Query(value = "update book set category = 'IT전문서'", nativeQuery = true)
    int updateCategories();

    @Query(value = "show tables", nativeQuery = true)
    List<String> showTables();

    @Query(value = "select * from book order by id desc limit 1", nativeQuery = true)
    Map<String, Object> findRawRecord();


}
