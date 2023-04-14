package com.multi.pratice.multipratice.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberHistory is a Querydsl query type for MemberHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberHistory extends EntityPathBase<MemberHistory> {

    private static final long serialVersionUID = 1774360922L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberHistory memberHistory = new QMemberHistory("memberHistory");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QAddress companyAddress;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    public final QAddress homeAddress;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMemberHistory(String variable) {
        this(MemberHistory.class, forVariable(variable), INITS);
    }

    public QMemberHistory(Path<? extends MemberHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberHistory(PathMetadata metadata, PathInits inits) {
        this(MemberHistory.class, metadata, inits);
    }

    public QMemberHistory(Class<? extends MemberHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.companyAddress = inits.isInitialized("companyAddress") ? new QAddress(forProperty("companyAddress")) : null;
        this.homeAddress = inits.isInitialized("homeAddress") ? new QAddress(forProperty("homeAddress")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

