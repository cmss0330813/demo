package com.example.demo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberEntity is a Querydsl query type for MemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEntity extends EntityPathBase<MemberEntity> {

    private static final long serialVersionUID = -2081947218L;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final StringPath department = createString("department");

    public final StringPath genre = createString("genre");

    public final NumberPath<Long> grade = createNumber("grade", Long.class);

    public final NumberPath<Long> member_id = createNumber("member_id", Long.class);

    public final StringPath password = createString("password");

    public final StringPath userName = createString("userName");

    public QMemberEntity(String variable) {
        super(MemberEntity.class, forVariable(variable));
    }

    public QMemberEntity(Path<? extends MemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberEntity(PathMetadata metadata) {
        super(MemberEntity.class, metadata);
    }

}

