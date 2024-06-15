package com.example.demo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = 1634233731L;

    public static final QBook book = new QBook("book");

    public final StringPath book_id = createString("book_id");

    public final StringPath bookcover = createString("bookcover");

    public final StringPath bookdetail = createString("bookdetail");

    public final StringPath bookname = createString("bookname");

    public final StringPath booknumber = createString("booknumber");

    public final StringPath iscertification = createString("iscertification");

    public final StringPath isExist = createString("isExist");

    public final StringPath isMajor = createString("isMajor");

    public final StringPath writer = createString("writer");

    public final StringPath year = createString("year");

    public QBook(String variable) {
        super(Book.class, forVariable(variable));
    }

    public QBook(Path<? extends Book> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBook(PathMetadata metadata) {
        super(Book.class, metadata);
    }

}

