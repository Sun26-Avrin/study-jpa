package com.study.structure.domain.pocketmark;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseEntityWithId is a Querydsl query type for BaseEntityWithId
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseEntityWithId extends EntityPathBase<BaseEntityWithId> {

    private static final long serialVersionUID = 73599683L;

    public static final QBaseEntityWithId baseEntityWithId = new QBaseEntityWithId("baseEntityWithId");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QBaseEntityWithId(String variable) {
        super(BaseEntityWithId.class, forVariable(variable));
    }

    public QBaseEntityWithId(Path<? extends BaseEntityWithId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseEntityWithId(PathMetadata metadata) {
        super(BaseEntityWithId.class, metadata);
    }

}

