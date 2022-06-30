package com.codecool.warehouseapp.service.location;

import com.codecool.warehouseapp.dao.location.ZoneDao;
import org.springframework.stereotype.Service;

@Service
public class ZoneService {

    private final ZoneDao dao;

    public ZoneService(ZoneDao dao) {
        this.dao = dao;
    }
}
