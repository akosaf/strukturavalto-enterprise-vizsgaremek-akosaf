package com.codecool.warehouseapp.service.location;

import com.codecool.warehouseapp.dao.location.RackDao;
import com.codecool.warehouseapp.model.location.Rack;
import com.codecool.warehouseapp.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RackService {

    private final RackDao dao;
    private final WarehouseService services;

    public RackService(RackDao dao, WarehouseService services) {
        this.dao = dao;
        this.services = services;
    }

    public List<Rack> findAll() {
        return dao.findAll();
    }

    public Rack save(Rack input) {
        Rack output = services.constructRack(input);
        return dao.save(output);
    }

    public void update(Rack input, Long id) {
        Rack output = services.constructRack(input, id);
        dao.save(output);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public Rack findById(Long id) {
        return dao.findById(id).orElseThrow();
    }
}
