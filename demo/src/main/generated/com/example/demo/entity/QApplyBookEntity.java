package com.example.demo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QApplyBookEntity is a Querydsl query type for ApplyBookEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QApplyBookEntity extends EntityPathBase<ApplyBookEntity> {

    private static final long serialVersionUID = 535563785L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QApplyBookEntity applyBookEntity = new QApplyBookEntity("applyBookEntity");

    public final NumberPath<Long> applyBook_id = createNumber("applyBook_id", Long.class);

    public final com.example.demo.QBook book;

    public QApplyBookEntity(String variable) {
        this(ApplyBookEntity.class, forVariable(variable), INITS);
    }

    public QApplyBookEntity(Path<? extends ApplyBookEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QApplyBookEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QApplyBookEntity(PathMetadata metadata, PathInits inits) {
        this(ApplyBookEntity.class, metadata, inits);
    }

    public QApplyBookEntity(Class<? extends ApplyBookEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.book = inits.isInitialized("book") ? new com.example.demo.QBook(forProperty("book")) : null;
    }

}

