package com.multi.pratice.multipratice.jpa.domain.converter;

import com.multi.pratice.multipratice.jpa.domain.Book;
import com.multi.pratice.multipratice.jpa.dto.BookStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * packageName : com.multi.pratice.multipratice.jpa.domain.converter
 * fileName : BookStatusConverter
 * author : taeil
 * date : 2023/04/07
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/07        taeil                   최초생성
 */
// -> autoApply : 자동 적용 속성 디폴트는 false
// 주의점은 개발자가 직접 생성한 클래스 타입으로만 사용해야만 한다. Integer String 등 에 대해서는 각 엔티티의 컬럼에 어노테이션을 지정해서 사용하는것이 좋다
@Converter(autoApply = true)
public class BookStatusConverter implements AttributeConverter<BookStatus, Integer> { // <entity의 attributeType, database의 column타입>
    // Converter : DB Data를 JAVA객체로 변경할 때, DB데이터와 자바의 객체 타입이 다를때 사용하는것이 Converter임
    // ex) DB의 Enum과 자바의 Enum Type 형식이 다를때 사용

    @Override
    public Integer convertToDatabaseColumn(BookStatus attribute) {
        // BookStatus라는 객체를 받아서 db에 저장할때 어떻게 할건지에 대한 처리
        return attribute.getCode();
    }

    @Override
    public BookStatus convertToEntityAttribute(Integer dbData) {
        // DB에서 Integer 데이터를 받아서 어떻게 할건지에 대한 처리
        return dbData != null ? new BookStatus(dbData) : null;
    }
}