package pl.estrix.backend.warehouse.executor;

import org.springframework.stereotype.Component;
import pl.estrix.common.dto.model.WarehouseDto;

@Component
public class DeleteWarehouseCommandExecutor extends BaseWarehouseCommandExecutor {

    public void delete(WarehouseDto dto){
        repository.delete(dto.getId());
    }
}
