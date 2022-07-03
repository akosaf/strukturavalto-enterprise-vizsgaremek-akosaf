package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.service.location.*;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class WarehouseService {

    private final AisleService aisleService;
    private final BinService binService;
    private final RackService rackService;
    private final ShelfService shelfService;
    private final ZoneService zoneService;

    private final CategoryService categoryService;
    private final LocationService locationService;
    private final ShipmentService shipmentService;
    private final StockService stockService;
    private final SupplierService supplierService;

    public WarehouseService(AisleService aisleService,
                            BinService binService,
                            RackService rackService,
                            ShelfService shelfService,
                            ZoneService zoneService,
                            CategoryService categoryService,
                            LocationService locationService,
                            ShipmentService shipmentService,
                            StockService stockService,
                            SupplierService supplierService) {
        this.aisleService = aisleService;
        this.binService = binService;
        this.rackService = rackService;
        this.shelfService = shelfService;
        this.zoneService = zoneService;
        this.categoryService = categoryService;
        this.locationService = locationService;
        this.shipmentService = shipmentService;
        this.stockService = stockService;
        this.supplierService = supplierService;
    }
}
