package pl.estrix.backend.warehouse.executor;

import org.springframework.stereotype.Component;
import pl.estrix.common.dto.model.UserDto;
import pl.estrix.common.dto.model.WarehouseDto;

@Component
public class UpdateWarehouseCommandExecutor extends BaseWarehouseCommandExecutor {

    public WarehouseDto update(WarehouseDto dto) {
        return this.mapEntityToDto(
                repository.save(this.mapDtoToEntity(dto)
                ));
    }
}
