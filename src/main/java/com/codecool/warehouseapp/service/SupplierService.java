package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.SupplierDao;
import com.codecool.warehouseapp.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierDao dao;
    private final InventoryService services;

    public SupplierService(SupplierDao dao, InventoryService services) {
        this.dao = dao;
        this.services = services;
    }

    public List<Supplier> findAll() {
        return dao.findAll();
    }

    public Supplier save(Supplier input) {
        Supplier output = services.constructSupplier(input);
        return dao.save(output);
    }

    public void update(Supplier input, Long id) {
        Supplier output = services.constructSupplier(input, id);
        dao.save(output);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public Supplier findById(Long id) {
        return dao.findById(id).orElseThrow();
    }
}
