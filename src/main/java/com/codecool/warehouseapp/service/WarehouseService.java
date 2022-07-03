package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.*;
import com.codecool.warehouseapp.dao.location.*;
import com.codecool.warehouseapp.service.location.*;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class WarehouseService {

    private final AisleDao aisleDao;
    private final BinDao binDao;
    private final RackDao rackDao;
    private final ShelfDao shelfDao;
    private final ZoneDao zoneDao;

    private final CategoryDao categoryDao;
    private final LocationDao locationDao;
    private final ShipmentDao shipmentDao;
    private final StockDao stockDao;
    private final SupplierDao supplierDao;

    public WarehouseService(AisleDao aisleDao,
                            BinDao binDao,
                            RackDao rackDao,
                            ShelfDao shelfDao,
                            ZoneDao zoneDao,
                            CategoryDao categoryDao,
                            LocationDao locationDao,
                            ShipmentDao shipmentDao,
                            StockDao stockDao,
                            SupplierDao supplierDao) {
        this.aisleDao = aisleDao;
        this.binDao = binDao;
        this.rackDao = rackDao;
        this.shelfDao = shelfDao;
        this.zoneDao = zoneDao;
        this.categoryDao = categoryDao;
        this.locationDao = locationDao;
        this.shipmentDao = shipmentDao;
        this.stockDao = stockDao;
        this.supplierDao = supplierDao;
    }
}
