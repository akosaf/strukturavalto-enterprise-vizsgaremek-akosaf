package com.codecool.warehouseapp.controller;

import com.codecool.warehouseapp.model.Stock;
import com.codecool.warehouseapp.service.StockService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

@RestController
public class InventoryController {
    private final StockService service;

    public InventoryController(StockService service) {
        this.service = service;
    }

    @PutMapping(value = "/{id}/increase")
    public Stock increaseStockQuantity(@PathVariable("id") Long id, @RequestParam("quantity") int quantity) {
        return service.increaseStockQuantity(id, quantity);
    }

    @PutMapping(value = "/{id}/decrease")
    public Stock decreaseStockQuantity(@PathVariable("id") Long id, @RequestParam("quantity") int quantity) {
        return service.decreaseStockQuantity(id, quantity);
    }

    @ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleNotFound() {}

    @ExceptionHandler({HttpMessageNotReadableException.class, ConstraintViolationException.class, InvalidParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private void handleBadRequest() {}

}
