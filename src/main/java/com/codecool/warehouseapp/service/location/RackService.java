package com.codecool.warehouseapp.service.location;

import com.codecool.warehouseapp.dao.location.RackDao;
import org.springframework.stereotype.Service;

@Service
public class RackService {

    private final RackDao dao;

    public RackService(RackDao dao) {
        this.dao = dao;
    }
}
