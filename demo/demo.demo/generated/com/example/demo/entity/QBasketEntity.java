package com.example.demo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBasketEntity is a Querydsl query type for BasketEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBasketEntity extends EntityPathBase<BasketEntity> {

    private static final long serialVersionUID = 899686362L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBasketEntity basketEntity = new QBasketEntity("basketEntity");

    public final NumberPath<Long> basket_id = createNumber("basket_id", Long.class);

    public final QBookEntity book;

    public final QMemberEntity member;

    public QBasketEntity(String variable) {
        this(BasketEntity.class, forVariable(variable), INITS);
    }

    public QBasketEntity(Path<? extends BasketEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBasketEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBasketEntity(PathMetadata metadata, PathInits inits) {
        this(BasketEntity.class, metadata, inits);
    }

    public QBasketEntity(Class<? extends BasketEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.book = inits.isInitialized("book") ? new QBookEntity(forProperty("book")) : null;
        this.member = inits.isInitialized("member") ? new QMemberEntity(forProperty("member")) : null;
    }

}

