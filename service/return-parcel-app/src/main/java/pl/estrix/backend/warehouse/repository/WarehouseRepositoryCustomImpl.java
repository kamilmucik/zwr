package pl.estrix.backend.warehouse.repository;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.Projections;
import org.springframework.stereotype.Repository;
import pl.estrix.backend.base.PagingCriteria;
import pl.estrix.backend.base.QueryDslRepositorySupportBase;
import pl.estrix.backend.user.dao.User;
import pl.estrix.backend.warehouse.dao.QWarehouse;
import pl.estrix.backend.warehouse.dao.Warehouse;
import pl.estrix.common.dto.WarehouseSearchCriteriaDto;

import java.util.List;

@Repository
public class WarehouseRepositoryCustomImpl extends QueryDslRepositorySupportBase implements WarehouseRepositoryCustom {

    private static final QWarehouse warehouse = new QWarehouse("warehouse");

    public WarehouseRepositoryCustomImpl() {
        super(User.class);
    }

    @Override
    public List<Warehouse> find(WarehouseSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        JPQLQuery query = getQueryForFind(searchCriteria);
//        query.orderBy(user.id.asc());
        addPagingCriteriaToQuery(query, pagingCriteria);
        return query.list(Projections.bean(
                Warehouse.class,
                warehouse.id,
                warehouse.placeName
        ));
    }

    @Override
    public long findCount(WarehouseSearchCriteriaDto searchCriteria) {
        JPQLQuery query = getQueryForFind(searchCriteria);
        return query.count();
    }

    private JPQLQuery getQueryForFind(WarehouseSearchCriteriaDto searchParams) {
        BooleanBuilder builder = new BooleanBuilder();
        JPQLQuery query = from(warehouse);

//        if (StringUtils.isNotEmpty(searchParams.getTableSearch())){
//            query.where(
//                    user.email.contains(searchParams.getTableSearch())
//                            .or(user.firstName.contains(searchParams.getTableSearch()))
//                            .or(user.lastName.contains(searchParams.getTableSearch()))
//            );
//        }

        query.where(builder);
        return query;
    }
}
