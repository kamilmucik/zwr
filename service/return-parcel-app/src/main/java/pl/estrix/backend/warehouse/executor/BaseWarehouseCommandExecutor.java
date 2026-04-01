package pl.estrix.backend.warehouse.executor;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import pl.estrix.backend.base.BaseCommandExecutor;
import pl.estrix.backend.user.dao.User;
import pl.estrix.backend.user.repository.UserRepository;
import pl.estrix.backend.user.repository.UserRepositoryCustom;
import pl.estrix.backend.warehouse.dao.Warehouse;
import pl.estrix.backend.warehouse.repository.WarehouseRepository;
import pl.estrix.backend.warehouse.repository.WarehouseRepositoryCustom;
import pl.estrix.common.dto.model.UserDto;
import pl.estrix.common.dto.model.WarehouseDto;

@Data
public class BaseWarehouseCommandExecutor extends BaseCommandExecutor<Warehouse, WarehouseDto> {

    @Autowired
    protected WarehouseRepository repository;

    @Autowired
    protected WarehouseRepositoryCustom customRepository;

    @Override
    protected Class<WarehouseDto> getDtoClass() {
        return WarehouseDto.class;
    }

    public Warehouse mapDtoToEntity(WarehouseDto dto) {
        Warehouse entity = new Warehouse();
        entity.setId(dto.getId());
        entity.setPlaceName(dto.getPlaceName());
        return entity;
    }

    public WarehouseDto mapEntityToDto(Warehouse entity) {
        WarehouseDto dto = new WarehouseDto();
        dto.setId(entity.getId());
        dto.setPlaceName(entity.getPlaceName());
        return dto;
    }
}
