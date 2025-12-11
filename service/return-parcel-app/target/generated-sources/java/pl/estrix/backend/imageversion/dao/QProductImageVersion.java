package pl.estrix.backend.imageversion.dao;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProductImageVersion is a Querydsl query type for ProductImageVersion
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProductImageVersion extends EntityPathBase<ProductImageVersion> {

    private static final long serialVersionUID = -703422822L;

    public static final QProductImageVersion productImageVersion = new QProductImageVersion("productImageVersion");

    public final pl.estrix.backend.base.QAuditableEntity _super = new pl.estrix.backend.base.QAuditableEntity(this);

    public final NumberPath<Long> artNumber = createNumber("artNumber", Long.class);

    public final StringPath ean = createString("ean");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final ListPath<ProductImageVersionRevision, QProductImageVersionRevision> revisions = this.<ProductImageVersionRevision, QProductImageVersionRevision>createList("revisions", ProductImageVersionRevision.class, QProductImageVersionRevision.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QProductImageVersion(String variable) {
        super(ProductImageVersion.class, forVariable(variable));
    }

    public QProductImageVersion(Path<? extends ProductImageVersion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductImageVersion(PathMetadata<?> metadata) {
        super(ProductImageVersion.class, metadata);
    }

}

