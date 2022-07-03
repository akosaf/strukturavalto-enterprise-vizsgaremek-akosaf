package com.codecool.warehouseapp.service.location;

import com.codecool.warehouseapp.dao.location.ShelfDao;
import com.codecool.warehouseapp.model.location.Shelf;
import com.codecool.warehouseapp.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfService {

    private final ShelfDao dao;
    private final WarehouseService services;

    public ShelfService(ShelfDao dao, WarehouseService services) {
        this.dao = dao;
        this.services = services;
    }

    public List<Shelf> findAll() {
        return dao.findAll();
    }

    public Shelf save(Shelf input) {
        Shelf output = services.constructShelf(input);
        return dao.save(output);
    }

    public void update(Shelf input, Long id) {
        Shelf output = services.constructShelf(input, id);
        dao.save(output);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public Shelf findById(Long id) {
        return dao.findById(id).orElseThrow();
    }
}
