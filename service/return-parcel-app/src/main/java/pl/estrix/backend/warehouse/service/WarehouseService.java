package pl.estrix.backend.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.estrix.backend.base.PagingCriteria;
import pl.estrix.backend.warehouse.executor.CreateWarehouseCommandExecutor;
import pl.estrix.backend.warehouse.executor.DeleteWarehouseCommandExecutor;
import pl.estrix.backend.warehouse.executor.ReadWarehouseCommandExecutor;
import pl.estrix.backend.warehouse.executor.UpdateWarehouseCommandExecutor;
import pl.estrix.common.base.ListResponseDto;
import pl.estrix.common.dto.GetShipmentDetailsDto;
import pl.estrix.common.dto.WarehouseSearchCriteriaDto;
import pl.estrix.common.dto.model.WarehouseDto;

import javax.transaction.Transactional;

@Service
public class WarehouseService {

    @Autowired
    private ReadWarehouseCommandExecutor readExecutor;
    @Autowired
    private CreateWarehouseCommandExecutor createExecutor;
    @Autowired
    private UpdateWarehouseCommandExecutor updateExecutor;
    @Autowired
    private DeleteWarehouseCommandExecutor deleteExecutor;

    public ListResponseDto<WarehouseDto> getItems(WarehouseSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria){
        return readExecutor.find(searchCriteria,pagingCriteria);
    }

    public WarehouseDto getItem(Long id){
        return readExecutor.findById(id);
    }

    @Transactional
    public WarehouseDto saveOrUpdate(WarehouseDto warehouseDto) {
        if (warehouseDto.getId() != null){
            return updateExecutor.update(warehouseDto);
        }
        return createExecutor.create(warehouseDto);
    }
    @Transactional
    public void delete(WarehouseDto warehouseDto) {
        deleteExecutor.delete(warehouseDto);
    }
}
