package com.codecool.warehouseapp.service.location;

import com.codecool.warehouseapp.dao.location.ZoneDao;
import com.codecool.warehouseapp.model.location.Zone;
import com.codecool.warehouseapp.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {

    private final ZoneDao dao;
    private final WarehouseService services;

    public ZoneService(ZoneDao dao, WarehouseService services) {
        this.dao = dao;
        this.services = services;
    }

    public List<Zone> findAll() {
        return dao.findAll();
    }

    public Zone save(Zone input) {
        Zone output = services.constructZone(input);
        return dao.save(output);
    }

    public void update(Zone input, Long id) {
        Zone output = services.constructZone(input, id);
        dao.save(output);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public Zone findById(Long id) {
        return dao.findById(id).orElseThrow();
    }
}
