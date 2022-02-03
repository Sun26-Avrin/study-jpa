package com.study.structure.domain.pocketmark;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBookmark is a Querydsl query type for Bookmark
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookmark extends EntityPathBase<Bookmark> {

    private static final long serialVersionUID = -1200145852L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBookmark bookmark = new QBookmark("bookmark");

    public final QItem _super;

    public final StringPath comment = createString("comment");

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

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt;

    public final StringPath url = createString("url");

    // inherited
    public final QUser user;

    //inherited
    public final NumberPath<Long> userId;

    //inherited
    public final NumberPath<java.math.BigDecimal> visitCount;

    public QBookmark(String variable) {
        this(Bookmark.class, forVariable(variable), INITS);
    }

    public QBookmark(Path<? extends Bookmark> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBookmark(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBookmark(PathMetadata metadata, PathInits inits) {
        this(Bookmark.class, metadata, inits);
    }

    public QBookmark(Class<? extends Bookmark> type, PathMetadata metadata, PathInits inits) {
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

