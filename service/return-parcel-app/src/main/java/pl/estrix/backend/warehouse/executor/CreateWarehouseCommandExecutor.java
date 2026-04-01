package pl.estrix.backend.warehouse.executor;

import org.springframework.stereotype.Component;
import pl.estrix.common.dto.model.UserDto;
import pl.estrix.common.dto.model.WarehouseDto;

@Component
public class CreateWarehouseCommandExecutor extends BaseWarehouseCommandExecutor {

    public WarehouseDto create(WarehouseDto warehouseDto) {
        return this.mapEntityToDto(
                repository.save(this.mapDtoToEntity(warehouseDto)
                ));
    }
}
