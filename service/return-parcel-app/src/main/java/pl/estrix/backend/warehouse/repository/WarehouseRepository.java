package pl.estrix.backend.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import pl.estrix.backend.warehouse.dao.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long>, QueryDslPredicateExecutor<Warehouse> {


}
