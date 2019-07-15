package com.mind.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudentEntity is a Querydsl query type for StudentEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentEntity extends EntityPathBase<StudentEntity> {

    private static final long serialVersionUID = -2045075198L;

    public static final QStudentEntity studentEntity = new QStudentEntity("studentEntity");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<StudentMarksEntity, QStudentMarksEntity> subjectmarkslist = this.<StudentMarksEntity, QStudentMarksEntity>createList("subjectmarkslist", StudentMarksEntity.class, QStudentMarksEntity.class, PathInits.DIRECT2);

    public QStudentEntity(String variable) {
        super(StudentEntity.class, forVariable(variable));
    }

    public QStudentEntity(Path<? extends StudentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentEntity(PathMetadata metadata) {
        super(StudentEntity.class, metadata);
    }

}

