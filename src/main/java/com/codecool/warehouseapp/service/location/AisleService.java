package com.codecool.warehouseapp.service.location;

import com.codecool.warehouseapp.dao.location.AisleDao;
import com.codecool.warehouseapp.model.location.Aisle;
import com.codecool.warehouseapp.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AisleService {

    private final AisleDao dao;
    private final WarehouseService services;

    public AisleService(AisleDao dao, WarehouseService services) {
        this.dao = dao;
        this.services = services;
    }

    public List<Aisle> findAll() {
        return dao.findAll();
    }

    public Aisle save(Aisle input) {
        Aisle output = services.constructAisle(input);
        return dao.save(output);
    }

    public void update(Aisle input, Long id) {
        Aisle output = services.constructAisle(input, id);
        dao.save(output);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public Aisle findById(Long id) {
        return dao.findById(id).orElseThrow();
    }
}
