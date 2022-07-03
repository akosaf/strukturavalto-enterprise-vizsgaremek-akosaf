package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.ShipmentDao;
import com.codecool.warehouseapp.model.Shipment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentDao dao;
    private final InventoryService services;

    public ShipmentService(ShipmentDao dao, InventoryService services) {
        this.dao = dao;
        this.services = services;
    }

    public List<Shipment> findAll() {
        return dao.findAll();
    }

    public Shipment save(Shipment input) {
        Shipment output = services.constructShipment(input);
        return dao.save(output);
    }

    public void update(Shipment input, Long id) {
        Shipment output = services.constructShipment(input, id);
        dao.save(output);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public Shipment findById(Long id) {
        return dao.findById(id).orElseThrow();
    }
}
