package com.study.structure.domain.pocketmark;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBookmark is a Querydsl query type for Bookmark
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookmark extends EntityPathBase<Bookmark> {

    private static final long serialVersionUID = -1200145852L;

    public static final QBookmark bookmark = new QBookmark("bookmark");

    public final QItem _super = new QItem(this);

    public final StringPath comment = createString("comment");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final NumberPath<Long> itemId = _super.itemId;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final NumberPath<Long> parentId = _super.parentId;

    //inherited
    public final ListPath<Tag, QTag> tags = _super.tags;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath url = createString("url");

    //inherited
    public final NumberPath<Long> userId = _super.userId;

    //inherited
    public final NumberPath<java.math.BigDecimal> visitCount = _super.visitCount;

    public QBookmark(String variable) {
        super(Bookmark.class, forVariable(variable));
    }

    public QBookmark(Path<? extends Bookmark> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookmark(PathMetadata metadata) {
        super(Bookmark.class, metadata);
    }

}

