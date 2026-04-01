package pl.estrix.backend.warehouse.repository;


import pl.estrix.backend.base.PagingCriteria;
import pl.estrix.backend.user.dao.User;
import pl.estrix.backend.warehouse.dao.Warehouse;
import pl.estrix.common.dto.UserSearchCriteriaDto;
import pl.estrix.common.dto.WarehouseSearchCriteriaDto;

import java.util.List;

public interface WarehouseRepositoryCustom {

    List<Warehouse> find(WarehouseSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria);

    long findCount(WarehouseSearchCriteriaDto searchCriteria);}
