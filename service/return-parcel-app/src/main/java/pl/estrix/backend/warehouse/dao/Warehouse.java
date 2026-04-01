package pl.estrix.backend.warehouse.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.estrix.backend.base.AuditableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;


@Entity
@Table(name = "warehouse",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id"}),
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warehouse extends AuditableEntity {

    @Size(min = 1, max = 50)
    @Column(name = "place_name", length = 50, nullable = false)
    private String placeName;

}
