package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.ShipmentDao;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {

    private final ShipmentDao dao;

    public ShipmentService(ShipmentDao dao) {
        this.dao = dao;
    }
}
