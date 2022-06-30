package com.codecool.warehouseapp.service.location;

import com.codecool.warehouseapp.dao.location.AisleDao;
import org.springframework.stereotype.Service;

@Service
public class AisleService {

    private final AisleDao dao;

    public AisleService(AisleDao dao) {
        this.dao = dao;
    }
}
