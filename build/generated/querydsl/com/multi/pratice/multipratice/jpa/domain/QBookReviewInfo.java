package com.multi.pratice.multipratice.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBookReviewInfo is a Querydsl query type for BookReviewInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookReviewInfo extends EntityPathBase<BookReviewInfo> {

    private static final long serialVersionUID = -1605182673L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBookReviewInfo bookReviewInfo = new QBookReviewInfo("bookReviewInfo");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Float> averageReviewScore = createNumber("averageReviewScore", Float.class);

    public final QBook book;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> reviewCount = createNumber("reviewCount", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QBookReviewInfo(String variable) {
        this(BookReviewInfo.class, forVariable(variable), INITS);
    }

    public QBookReviewInfo(Path<? extends BookReviewInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBookReviewInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBookReviewInfo(PathMetadata metadata, PathInits inits) {
        this(BookReviewInfo.class, metadata, inits);
    }

    public QBookReviewInfo(Class<? extends BookReviewInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.book = inits.isInitialized("book") ? new QBook(forProperty("book"), inits.get("book")) : null;
    }

}

