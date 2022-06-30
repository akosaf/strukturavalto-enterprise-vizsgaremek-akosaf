package com.codecool.warehouseapp.service.location;

import com.codecool.warehouseapp.dao.location.BinDao;
import org.springframework.stereotype.Service;

@Service
public class BinService {

    private final BinDao dao;

    public BinService(BinDao dao) {
        this.dao = dao;
    }
}
