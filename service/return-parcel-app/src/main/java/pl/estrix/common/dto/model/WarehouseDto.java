package pl.estrix.common.dto.model;

import lombok.*;
import pl.estrix.backend.base.BaseEntityDto;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class WarehouseDto extends BaseEntityDto<Long> {


    private String placeName;

    public Long getId(){
        return super.getId();
    }

    public String toString(){
        return placeName;
    }
}
