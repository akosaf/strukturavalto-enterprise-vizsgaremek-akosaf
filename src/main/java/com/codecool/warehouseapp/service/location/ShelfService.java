package com.codecool.warehouseapp.service.location;

import com.codecool.warehouseapp.dao.location.ShelfDao;
import org.springframework.stereotype.Service;

@Service
public class ShelfService {

    private final ShelfDao dao;

    public ShelfService(ShelfDao dao) {
        this.dao = dao;
    }
}
