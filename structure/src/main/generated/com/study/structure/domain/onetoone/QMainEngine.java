package com.study.structure.domain.onetoone;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMainEngine is a Querydsl query type for MainEngine
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMainEngine extends EntityPathBase<MainEngine> {

    private static final long serialVersionUID = -1889440665L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMainEngine mainEngine = new QMainEngine("mainEngine");

    public final QCar car;

    public final StringPath engineInfo = createString("engineInfo");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QMainEngine(String variable) {
        this(MainEngine.class, forVariable(variable), INITS);
    }

    public QMainEngine(Path<? extends MainEngine> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMainEngine(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMainEngine(PathMetadata metadata, PathInits inits) {
        this(MainEngine.class, metadata, inits);
    }

    public QMainEngine(Class<? extends MainEngine> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.car = inits.isInitialized("car") ? new QCar(forProperty("car"), inits.get("car")) : null;
    }

}

