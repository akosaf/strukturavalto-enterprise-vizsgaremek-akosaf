package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.*;
import com.codecool.warehouseapp.dao.location.*;
import com.codecool.warehouseapp.model.*;
import com.codecool.warehouseapp.model.location.*;
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

    protected Stock constructStock(Stock input) {
        Stock output = stockDao.findById(input.getId()).orElse(new Stock());
        fillStockData(input, output);
        return stockDao.save(output);
    }

    protected Stock constructStock(Stock input, Long id) {
        Stock output = stockDao.findById(id).orElseThrow();
        fillStockData(input, output);
        return stockDao.save(output);
    }

    private void fillStockData(Stock input, Stock output) {
        output.setName(input.getName());
        output.setDescription(input.getDescription());
        output.setExpiration(input.getExpiration());
        output.setPrice(input.getPrice());
        output.setQuantity(input.getQuantity());
        output.setCountryOfOrigin(input.getCountryOfOrigin());

        output.setCategory(constructCategory(input.getCategory()));

        output.setShipment(constructShipment(input.getShipment()));

        output.setLocation(constructLocation(input.getLocation()));
    }

    protected Category constructCategory(Category input) {
        Category output = categoryDao.findById(input.getId()).orElse(new Category());
        fillCategoryData(output, input);
        return categoryDao.save(output);
    }

    protected Category constructCategory(Category input, Long id) {
        Category output = categoryDao.findById(id).orElseThrow();
        fillCategoryData(output, input);
        return categoryDao.save(output);
    }

    private void fillCategoryData(Category output, Category input) {
        output.setName(input.getName());
    }

    protected Location constructLocation(Location input) {
        Location output = locationDao.findById(input.getId()).orElse(new Location());
        fillLocationData(input, output);
        return locationDao.save(output);
    }

    protected Location constructLocation(Location input, Long id) {
        Location output = locationDao.findById(id).orElseThrow();
        fillLocationData(input, output);
        return locationDao.save(output);
    }

    private void fillLocationData(Location input, Location output) {
        output.setBin(constructBin(input.getBin()));
//        output.setShelf(constructShelf(input.getShelf()));
//        output.setRack(constructRack(input.getRack()));
//        output.setAisle(constructAisle(input.getAisle()));
//        output.setZone(constructZone(input.getZone()));
    }

    protected Shipment constructShipment(Shipment input) {
        Shipment output = shipmentDao.findById(input.getId()).orElse(new Shipment());
        fillShipmentData(input, output);
        return shipmentDao.save(output);
    }

    protected Shipment constructShipment(Shipment input, Long id) {
        Shipment output = shipmentDao.findById(id).orElseThrow();
        fillShipmentData(input, output);
        return shipmentDao.save(output);
    }

    private void fillShipmentData(Shipment input, Shipment output) {
        output.setShipmentDate(input.getShipmentDate());
        output.setSupplier(constructSupplier(input.getSupplier()));
        output.setWeight(input.getWeight());
        output.setCurrency(input.getCurrency());
    }

    protected Supplier constructSupplier(Supplier input) {
        Supplier output = supplierDao.findById(input.getId()).orElse(new Supplier());
        fillSupplierData(input, output);
        return supplierDao.save(output);
    }

    protected Supplier constructSupplier(Supplier input, Long id) {
        Supplier output = supplierDao.findById(id).orElseThrow();
        fillSupplierData(input, output);
        return supplierDao.save(output);
    }

    private void fillSupplierData(Supplier input, Supplier output) {
        output.setName(input.getName());
        output.setCountry(input.getCountry());
        output.setRegistrationDate(input.getRegistrationDate());
        output.setDiscount(input.getDiscount());
    }

    public Aisle constructAisle(Aisle input) {
        Aisle output = aisleDao.findById(input.getId()).orElse(new Aisle());
        fillAisleData(input, output);
        return aisleDao.save(output);
    }

    public Aisle constructAisle(Aisle input, Long id) {
        Aisle output = aisleDao.findById(id).orElseThrow();
        fillAisleData(input, output);
        return aisleDao.save(output);
    }

    private void fillAisleData(Aisle input, Aisle output) {
        output.setName(input.getName());
        output.setZone(constructZone(input.getZone()));
    }

    public Bin constructBin(Bin input) {
        Bin output = binDao.findById(input.getId()).orElse(new Bin());
        fillBinData(input, output);
        return binDao.save(output);
    }

    public Bin constructBin(Bin input, Long id) {
        Bin output = binDao.findById(id).orElseThrow();
        fillBinData(input, output);
        return binDao.save(output);
    }

    private void fillBinData(Bin input, Bin output) {
        output.setName(input.getName());
        output.setShelf(constructShelf(input.getShelf()));
    }

    public Rack constructRack(Rack input) {
        Rack output = rackDao.findById(input.getId()).orElse(new Rack());
        fillRackData(input, output);
        return rackDao.save(output);
    }

    public Rack constructRack(Rack input, Long id) {
        Rack output = rackDao.findById(id).orElseThrow();
        fillRackData(input, output);
        return rackDao.save(output);
    }

    private void fillRackData(Rack input, Rack output) {
        output.setName(input.getName());
        output.setAisle(constructAisle(input.getAisle()));
    }

    public Shelf constructShelf(Shelf input) {
        Shelf output = shelfDao.findById(input.getId()).orElse(new Shelf());
        fillShelfData(input, output);
        return shelfDao.save(output);
    }

    public Shelf constructShelf(Shelf input, Long id) {
        Shelf output = shelfDao.findById(id).orElseThrow();
        fillShelfData(input, output);
        return shelfDao.save(output);
    }

    private void fillShelfData(Shelf input, Shelf output) {
        output.setName(input.getName());
        output.setRack(constructRack(input.getRack()));
    }

    public Zone constructZone(Zone input) {
        Zone output = zoneDao.findById(input.getId()).orElse(new Zone());
        fillZoneData(input, output);
        return zoneDao.save(output);
    }

    public Zone constructZone(Zone input, Long id) {
        Zone output = zoneDao.findById(id).orElseThrow();
        fillZoneData(input, output);
        return zoneDao.save(output);
    }

    private void fillZoneData(Zone input, Zone output) {
        output.setName(input.getName());
    }

}
