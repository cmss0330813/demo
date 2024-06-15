package com.example.demo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBookEntity is a Querydsl query type for BookEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookEntity extends EntityPathBase<BookEntity> {

    private static final long serialVersionUID = -1391629571L;

    public static final QBookEntity bookEntity = new QBookEntity("bookEntity");

    public final StringPath book_id = createString("book_id");

    public final StringPath bookCover = createString("bookCover");

    public final StringPath bookDetail = createString("bookDetail");

    public final StringPath bookName = createString("bookName");

    public final StringPath bookNumber = createString("bookNumber");

    public final StringPath genre = createString("genre");

    public final StringPath isCertification = createString("isCertification");

    public final StringPath isExist = createString("isExist");

    public final StringPath isMajor = createString("isMajor");

    public final StringPath isStored = createString("isStored");

    public final StringPath writer = createString("writer");

    public QBookEntity(String variable) {
        super(BookEntity.class, forVariable(variable));
    }

    public QBookEntity(Path<? extends BookEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookEntity(PathMetadata metadata) {
        super(BookEntity.class, metadata);
    }

}

