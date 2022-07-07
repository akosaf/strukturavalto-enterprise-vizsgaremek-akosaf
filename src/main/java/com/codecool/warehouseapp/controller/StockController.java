package com.codecool.warehouseapp.controller;

import com.codecool.warehouseapp.model.Stock;
import com.codecool.warehouseapp.service.StockService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

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
    public Stock save(@Valid @RequestBody Stock input) {
        return service.save(input);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Stock input, @PathVariable("id") Long id) {
        service.update(input, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleNotFound() {}

    @ExceptionHandler({HttpMessageNotReadableException.class, ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private void handleBadRequest() {}

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    private void handleConflict() {}

}