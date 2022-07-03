package com.codecool.warehouseapp.controller;

import com.codecool.warehouseapp.model.Shipment;
import com.codecool.warehouseapp.service.ShipmentService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    private final ShipmentService service;

    public ShipmentController(ShipmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Shipment> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Shipment getItemByID(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Shipment save(@Valid @RequestBody Shipment input) {
        return service.save(input);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Shipment input, @PathVariable("id") Long id) {
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

}
