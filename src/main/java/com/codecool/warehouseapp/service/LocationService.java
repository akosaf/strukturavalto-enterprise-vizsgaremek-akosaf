package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.LocationDao;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final LocationDao dao;

    public LocationService(LocationDao dao) {
        this.dao = dao;
    }
}
