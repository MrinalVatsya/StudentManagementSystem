package com.mind.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudentMarksEntity is a Querydsl query type for StudentMarksEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentMarksEntity extends EntityPathBase<StudentMarksEntity> {

    private static final long serialVersionUID = 1494365450L;

    public static final QStudentMarksEntity studentMarksEntity = new QStudentMarksEntity("studentMarksEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> marks = createNumber("marks", Integer.class);

    public final NumberPath<Long> rollNo = createNumber("rollNo", Long.class);

    public final StringPath subjectname = createString("subjectname");

    public QStudentMarksEntity(String variable) {
        super(StudentMarksEntity.class, forVariable(variable));
    }

    public QStudentMarksEntity(Path<? extends StudentMarksEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentMarksEntity(PathMetadata metadata) {
        super(StudentMarksEntity.class, metadata);
    }

}

