package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.StockDao;
import com.codecool.warehouseapp.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockDao dao;
    private final WarehouseService services;

    public StockService(StockDao dao, WarehouseService services) {
        this.dao = dao;
        this.services = services;
    }

    public List<Stock> findAll() {
        return dao.findAll();
    }

    public Stock save(Stock input) {
        Stock stock = new Stock();
        stock.setId(input.getId());
        constructStock(input, stock);

        return dao.save(stock);
    }

    public void update(Stock input, Long id) {
        Stock stock = new Stock();
        stock.setId(id);
        constructStock(input, stock);
        dao.save(stock);
    }

    private void constructStock(Stock input, Stock stock) {
        stock.setName(input.getName());
        stock.setDescription(input.getDescription());
        stock.setExpiration(input.getExpiration());
        stock.setPrice(input.getPrice());
        stock.setCountryOfOrigin(input.getCountryOfOrigin());

        Category category = new Category();
        category.setName(input.getCategory().getName());
        stock.setCategory(category);

        Shipment shipment = new Shipment();
        shipment.setShipmentDate(input.getShipment().getShipmentDate());
        shipment.setCurrency(input.getShipment().getCurrency());
        Supplier supplier = new Supplier();
        supplier.setName(input.getShipment().getSupplier().getName());
        supplier.setCountry(input.getShipment().getSupplier().getCountry());
        supplier.setDiscount(input.getShipment().getSupplier().getDiscount());
        supplier.setRegistrationDate(input.getShipment().getSupplier().getRegistrationDate());
        shipment.setSupplier(supplier);
        shipment.setWeight(input.getShipment().getWeight());
        stock.setShipment(shipment);

        Location location = new Location();
        stock.setLocation(location);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public Stock findById(Long id) {
        return dao.findById(id).get();
    }
}
