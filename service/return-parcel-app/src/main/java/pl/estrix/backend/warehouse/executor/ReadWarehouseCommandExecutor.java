package pl.estrix.backend.warehouse.executor;

import org.springframework.stereotype.Component;
import pl.estrix.backend.base.PagingCriteria;
import pl.estrix.backend.warehouse.dao.Warehouse;
import pl.estrix.common.base.ListResponseDto;
import pl.estrix.common.dto.WarehouseSearchCriteriaDto;
import pl.estrix.common.dto.model.WarehouseDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReadWarehouseCommandExecutor extends BaseWarehouseCommandExecutor {


    public WarehouseDto findById(Long id) {
        return mapEntityToDto(repository.findOne(id));
    }


    public ListResponseDto<WarehouseDto> find(WarehouseSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        List<Warehouse> result = customRepository.find(searchCriteria, pagingCriteria);
        List<WarehouseDto> queryResultList = result
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());

        return createListResponseDto(pagingCriteria, () -> queryResultList, () -> (int) customRepository.findCount(searchCriteria));
    }
}
