package com.multi.pratice.multipratice.jpa.domain.mappedbytest.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMapTeam is a Querydsl query type for MapTeam
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMapTeam extends EntityPathBase<MapTeam> {

    private static final long serialVersionUID = 1058263617L;

    public static final QMapTeam mapTeam = new QMapTeam("mapTeam");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<MapMember, QMapMember> members = this.<MapMember, QMapMember>createList("members", MapMember.class, QMapMember.class, PathInits.DIRECT2);

    public final StringPath teamName = createString("teamName");

    public QMapTeam(String variable) {
        super(MapTeam.class, forVariable(variable));
    }

    public QMapTeam(Path<? extends MapTeam> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMapTeam(PathMetadata metadata) {
        super(MapTeam.class, metadata);
    }

}

