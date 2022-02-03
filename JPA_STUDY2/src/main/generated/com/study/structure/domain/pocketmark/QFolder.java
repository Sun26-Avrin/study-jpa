package com.study.structure.domain.pocketmark;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFolder is a Querydsl query type for Folder
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFolder extends EntityPathBase<Folder> {

    private static final long serialVersionUID = 1386913020L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFolder folder = new QFolder("folder");

    public final QItem _super;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    //inherited
    public final BooleanPath deleted;

    //inherited
    public final NumberPath<Long> itemId;

    //inherited
    public final StringPath name;

    //inherited
    public final NumberPath<Long> parentId;

    //inherited
    public final ListPath<Tag, QTag> tags;

    public final StringPath test = createString("test");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt;

    // inherited
    public final QUser user;

    //inherited
    public final NumberPath<Long> userId;

    //inherited
    public final NumberPath<java.math.BigDecimal> visitCount;

    public QFolder(String variable) {
        this(Folder.class, forVariable(variable), INITS);
    }

    public QFolder(Path<? extends Folder> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFolder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFolder(PathMetadata metadata, PathInits inits) {
        this(Folder.class, metadata, inits);
    }

    public QFolder(Class<? extends Folder> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QItem(type, metadata, inits);
        this.createdAt = _super.createdAt;
        this.deleted = _super.deleted;
        this.itemId = _super.itemId;
        this.name = _super.name;
        this.parentId = _super.parentId;
        this.tags = _super.tags;
        this.updatedAt = _super.updatedAt;
        this.user = _super.user;
        this.userId = _super.userId;
        this.visitCount = _super.visitCount;
    }

}

