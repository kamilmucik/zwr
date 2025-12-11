package pl.estrix.backend.imageversion.dao;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProductImageVersionRevision is a Querydsl query type for ProductImageVersionRevision
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProductImageVersionRevision extends EntityPathBase<ProductImageVersionRevision> {

    private static final long serialVersionUID = 101613717L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductImageVersionRevision productImageVersionRevision = new QProductImageVersionRevision("productImageVersionRevision");

    public final pl.estrix.backend.base.QAuditableEntity _super = new pl.estrix.backend.base.QAuditableEntity(this);

    public final StringPath comment = createString("comment");

    public final StringPath description = createString("description");

    public final StringPath hashGroup = createString("hashGroup");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath imgPath = createString("imgPath");

    public final DateTimePath<java.time.LocalDateTime> lastUpdate = createDateTime("lastUpdate", java.time.LocalDateTime.class);

    public final BooleanPath main = createBoolean("main");

    public final NumberPath<Long> orderTimestamp = createNumber("orderTimestamp", Long.class);

    public final QProductImageVersion productImageVersion;

    public QProductImageVersionRevision(String variable) {
        this(ProductImageVersionRevision.class, forVariable(variable), INITS);
    }

    public QProductImageVersionRevision(Path<? extends ProductImageVersionRevision> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProductImageVersionRevision(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProductImageVersionRevision(PathMetadata<?> metadata, PathInits inits) {
        this(ProductImageVersionRevision.class, metadata, inits);
    }

    public QProductImageVersionRevision(Class<? extends ProductImageVersionRevision> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productImageVersion = inits.isInitialized("productImageVersion") ? new QProductImageVersion(forProperty("productImageVersion")) : null;
    }

}

