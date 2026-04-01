package pl.estrix.common.dto;

import lombok.*;
import org.primefaces.model.SortOrder;
import pl.estrix.common.dto.model.UserDto;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ReleaseArticleSearchCriteriaDto {

    private String tableSearch;

    private UserDto userDto;

    private String sortField;
    private SortOrder sortOrder;
}
