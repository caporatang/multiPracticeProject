package com.multi.pratice.multipratice.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTestMember is a Querydsl query type for TestMember
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTestMember extends EntityPathBase<TestMember> {

    private static final long serialVersionUID = -904375028L;

    public static final QTestMember testMember = new QTestMember("testMember");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QTestMember(String variable) {
        super(TestMember.class, forVariable(variable));
    }

    public QTestMember(Path<? extends TestMember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTestMember(PathMetadata metadata) {
        super(TestMember.class, metadata);
    }

}

