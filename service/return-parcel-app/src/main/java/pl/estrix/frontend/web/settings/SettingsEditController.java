package pl.estrix.frontend.web.settings;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.estrix.backend.print.service.PrinterService;
import pl.estrix.backend.settings.service.SettingService;
import pl.estrix.backend.warehouse.service.WarehouseService;
import pl.estrix.common.dto.model.PrinterDto;
import pl.estrix.common.dto.model.SettingsDto;
import pl.estrix.common.dto.model.WarehouseDto;
import pl.estrix.frontend.jsf.FacesViewScope;
import pl.estrix.frontend.web.MainController;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

@Component("settingsEditController")
@Scope(FacesViewScope.NAME)
@Getter
@Setter
public class SettingsEditController extends MainController {


    private static final Logger LOGGER = LoggerFactory.getLogger(SettingsEditController.class);

    private SettingsDto selected;

    private List<PrinterDto> printers;
    private PrinterDto selectedPrinter;
    private PrinterDto newPrinter;

    private List<WarehouseDto> warehouses;
    private WarehouseDto selectedWarehouse;


    @Autowired
    private PrinterService printerService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private SettingService settingService;

    @PostConstruct
    public void init() {
        selected = settingService.getSetting();
        printers = printerService.findAllPrinters();
        newPrinter = new PrinterDto();

        warehouses = warehouseService.getItems(null, null).getData();
    }

    public void saveDetail() throws Exception {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try {
            settingService.savetSetting(selected);
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Zapis rekordu", ""));
        } catch (Exception e) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Zapis rekordu", ""));
        }
    }

    public void error() throws Exception {
        throw new Exception("test");
    }

    public void shouldDefault(Long id) {
        PrinterDto tmp = printerService.getDatefault();
        selectedPrinter = printerService.get(id);

        if (tmp != null){
            tmp.setIsDefault(Boolean.FALSE);
            printerService.update(tmp);
        }

        selectedPrinter.setIsDefault(Boolean.TRUE);
        printerService.update(selectedPrinter);

        printers = printerService.findAllPrinters();
    }

    public void refreshPrinter(){
//        printerService.findPrinters();
    }

    public void addPrinter(){
        newPrinter.setIsDefault(false);
        newPrinter.setActive(true);
        printerService.create(newPrinter);
    }

    public void deletePrinter(Long id) {
        selectedPrinter = printerService.get(id);
        if (selectedPrinter != null) {
            printerService.delete(selectedPrinter.getId());
        }
        printers = printerService.findAllPrinters();
    }

    public void editWarehouse(Long id) {
        if (id == null || id == 0) {
            selectedWarehouse = new WarehouseDto();
        } else {
            selectedWarehouse = warehouseService.getItem(id);
        }
    }

    public void deleteWarehouse() {
        LOGGER.debug("deleteWarehouse: {}", selectedWarehouse.getPlaceName());
        warehouseService.delete(selectedWarehouse);

        warehouses = warehouseService.getItems(null, null).getData();
    }
    public void saveWarehouse() {
        LOGGER.debug("saveWarehouse: {}", selectedWarehouse.getPlaceName());
        warehouseService.saveOrUpdate(selectedWarehouse);

        warehouses = warehouseService.getItems(null, null).getData();
    }

}
