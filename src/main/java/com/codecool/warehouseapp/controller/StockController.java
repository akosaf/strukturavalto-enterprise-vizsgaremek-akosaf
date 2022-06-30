package com.codecool.warehouseapp.controller;

import com.codecool.warehouseapp.model.Stock;
import com.codecool.warehouseapp.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> findAll() {
        return stockService.findAll();
    }

//    @GetMapping("/{id}")
//    public Item getItemById(@PathVariable("id") UUID id) {
//        return itemService.findById(id);
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Stock> getUserByID(@PathVariable("id") Long id) {
        Stock item = stockService.findById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping
    public Stock save(@RequestBody Stock stock) {
        return stockService.save(stock);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Stock stock, @PathVariable("id") Long id) {
        stockService.update(stock, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        stockService.delete(id);
    }

}
