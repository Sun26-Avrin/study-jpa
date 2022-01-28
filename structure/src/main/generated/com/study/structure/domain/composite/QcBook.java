package com.study.structure.domain.composite;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QcBook is a Querydsl query type for cBook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QcBook extends EntityPathBase<cBook> {

    private static final long serialVersionUID = 1027407368L;

    public static final QcBook cBook = new QcBook("cBook");

    public final StringPath author = createString("author");

    public final StringPath detail = createString("detail");

    public final NumberPath<Integer> idx = createNumber("idx", Integer.class);

    public final StringPath name = createString("name");

    public QcBook(String variable) {
        super(cBook.class, forVariable(variable));
    }

    public QcBook(Path<? extends cBook> path) {
        super(path.getType(), path.getMetadata());
    }

    public QcBook(PathMetadata metadata) {
        super(cBook.class, metadata);
    }

}

