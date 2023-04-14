package com.multi.pratice.multipratice.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPublisher is a Querydsl query type for Publisher
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPublisher extends EntityPathBase<Publisher> {

    private static final long serialVersionUID = 121563836L;

    public static final QPublisher publisher = new QPublisher("publisher");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final ListPath<Book, QBook> books = this.<Book, QBook>createList("books", Book.class, QBook.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QPublisher(String variable) {
        super(Publisher.class, forVariable(variable));
    }

    public QPublisher(Path<? extends Publisher> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPublisher(PathMetadata metadata) {
        super(Publisher.class, metadata);
    }

}

