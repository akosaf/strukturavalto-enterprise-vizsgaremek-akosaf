package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.LocationDao;
import com.codecool.warehouseapp.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationDao dao;
    private final WarehouseService services;

    public LocationService(LocationDao dao, WarehouseService services) {
        this.dao = dao;
        this.services = services;
    }

    public List<Location> findAll() {
        return dao.findAll();
    }

    public Location save(Location input) {
        Location output = services.constructLocation(input);
        return dao.save(output);
    }

    public void update(Location input, Long id) {
        Location output = services.constructLocation(input, id);
        dao.save(output);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public Location findById(Long id) {
        return dao.findById(id).orElseThrow();
    }
}
