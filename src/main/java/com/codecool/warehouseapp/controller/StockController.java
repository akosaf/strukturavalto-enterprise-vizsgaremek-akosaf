package com.codecool.warehouseapp.controller;

import com.codecool.warehouseapp.model.Stock;
import com.codecool.warehouseapp.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService service;

    public StockController(StockService stockService) {
        this.service = stockService;
    }

    @GetMapping
    public List<Stock> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Stock getItemByID(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Stock save(@RequestBody Stock input) {
        return service.save(input);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Stock input, @PathVariable("id") Long id) {
        service.update(input, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleNotFound() {}

}
