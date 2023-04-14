package com.multi.pratice.multipratice.jpa.domain.mappedbytest.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMapMember is a Querydsl query type for MapMember
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMapMember extends EntityPathBase<MapMember> {

    private static final long serialVersionUID = -1115967106L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMapMember mapMember = new QMapMember("mapMember");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMapTeam mapTeam;

    public final StringPath username = createString("username");

    public QMapMember(String variable) {
        this(MapMember.class, forVariable(variable), INITS);
    }

    public QMapMember(Path<? extends MapMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMapMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMapMember(PathMetadata metadata, PathInits inits) {
        this(MapMember.class, metadata, inits);
    }

    public QMapMember(Class<? extends MapMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mapTeam = inits.isInitialized("mapTeam") ? new QMapTeam(forProperty("mapTeam")) : null;
    }

}

