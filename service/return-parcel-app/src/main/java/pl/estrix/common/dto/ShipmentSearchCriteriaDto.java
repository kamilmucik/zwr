package pl.estrix.common.dto;


import lombok.*;
import org.primefaces.model.SortOrder;
import pl.estrix.common.dto.model.UserDto;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShipmentSearchCriteriaDto {

    private String tableSearch;
    private Boolean active;
    private UserDto userDto;

    private String sortField;
    private SortOrder sortOrder;
}
