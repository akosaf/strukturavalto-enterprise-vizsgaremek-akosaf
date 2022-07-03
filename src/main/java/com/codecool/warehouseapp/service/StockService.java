package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.StockDao;
import com.codecool.warehouseapp.model.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockDao dao;
    private final InventoryService services;

    public StockService(StockDao dao, InventoryService services) {
        this.dao = dao;
        this.services = services;
    }

    public List<Stock> findAll() {
        return dao.findAll();
    }

    public Stock save(Stock input) {
        Stock output = services.constructStock(input);
        return dao.save(output);
    }

    public void update(Stock input, Long id) {
        Stock output = services.constructStock(input, id);
        dao.save(output);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public Stock findById(Long id) {
        return dao.findById(id).orElseThrow();
    }
}
