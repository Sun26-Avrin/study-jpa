package com.study.structure.domain.pocketmark;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFolder is a Querydsl query type for Folder
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFolder extends EntityPathBase<Folder> {

    private static final long serialVersionUID = 1386913020L;

    public static final QFolder folder = new QFolder("folder");

    public final QItem _super = new QItem(this);

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

    //inherited
    public final NumberPath<Long> userId = _super.userId;

    //inherited
    public final NumberPath<java.math.BigDecimal> visitCount = _super.visitCount;

    public QFolder(String variable) {
        super(Folder.class, forVariable(variable));
    }

    public QFolder(Path<? extends Folder> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFolder(PathMetadata metadata) {
        super(Folder.class, metadata);
    }

}

