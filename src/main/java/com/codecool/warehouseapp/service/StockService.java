package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.StockDao;
import com.codecool.warehouseapp.model.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockDao stockDao;

    public StockService(StockDao itemDao) {
        this.stockDao = itemDao;
    }

    public List<Stock> findAll() {
        return stockDao.findAll();
    }

    public Stock save(Stock input) {
        Stock stock = new Stock();
        stock.setId(input.getId());
        constructStock(input, stock);

        return stockDao.save(stock);
    }

    public void update(Stock input, Long id) {
        Stock stock = new Stock();
        stock.setId(id);
        constructStock(input, stock);
        stockDao.save(stock);
    }

    private void constructStock(Stock input, Stock stock) {
        stock.setName(input.getName());
        stock.setDescription(input.getDescription());
        stock.setExpiration(input.getExpiration());
        stock.setPrice(input.getPrice());
        stock.setCountryOfOrigin(input.getCountryOfOrigin());
        stock.setCategory(input.getCategory());
        stock.setShipment(input.getShipment());
        stock.setLocation(input.getLocation());
    }

    public void delete(Long id) {
        stockDao.deleteById(id);
    }

    public Stock findById(Long id) {
        return stockDao.findById(id).get();
    }
}
