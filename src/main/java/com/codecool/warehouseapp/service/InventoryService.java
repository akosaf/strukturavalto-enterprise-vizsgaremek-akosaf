package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.CategoryDao;
import com.codecool.warehouseapp.dao.ShipmentDao;
import com.codecool.warehouseapp.dao.StockDao;
import com.codecool.warehouseapp.dao.SupplierDao;
import com.codecool.warehouseapp.model.Category;
import com.codecool.warehouseapp.model.Shipment;
import com.codecool.warehouseapp.model.Stock;
import com.codecool.warehouseapp.model.Supplier;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class InventoryService {

    private final CategoryDao categoryDao;
    private final ShipmentDao shipmentDao;
    private final StockDao stockDao;
    private final SupplierDao supplierDao;

    public InventoryService(
                            CategoryDao categoryDao,
                            ShipmentDao shipmentDao,
                            StockDao stockDao,
                            SupplierDao supplierDao) {
        this.categoryDao = categoryDao;
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

}
