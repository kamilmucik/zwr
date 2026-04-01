package pl.estrix.frontend.web.scan;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.estrix.backend.shipment.service.ShipmentService;
import pl.estrix.common.dto.model.ShipmentDto;
import pl.estrix.frontend.jsf.FacesViewScope;
import pl.estrix.frontend.web.MainController;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Getter
@Setter
@Component("scanListController")
@Scope(FacesViewScope.NAME)
public class ScanListController extends MainController implements Serializable {

    private LazyDataModel<ShipmentDto> lazyModel;

    private ShipmentDto selectedItem;

    private String searchText;

    @Autowired
    private ShipmentService shipmentService;

    @PostConstruct
    public void init() {
        super.init();
        tablePageInx = 1;
        searchText = (String) getContext().getExternalContext().getSessionMap().get("_scan_list_search");

        lazyModel = new ScanLazyDataModel(shipmentService, getCurrentUser(), searchText);
    }

    public void edit(Long id) {
        if (id == null || id == 0) {

        } else {
            selectedItem = shipmentService.getItem(id).getShipmentDto();
        }
    }

    public void search() {
        lazyModel = new ScanLazyDataModel(shipmentService,getCurrentUser(), searchText);
    }

}
