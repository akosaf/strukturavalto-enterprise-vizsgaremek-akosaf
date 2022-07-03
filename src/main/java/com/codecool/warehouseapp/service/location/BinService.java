package com.codecool.warehouseapp.service.location;

import com.codecool.warehouseapp.dao.location.BinDao;
import com.codecool.warehouseapp.model.location.Bin;
import com.codecool.warehouseapp.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinService {

    private final BinDao dao;
    private final WarehouseService services;

    public BinService(BinDao dao, WarehouseService services) {
        this.dao = dao;
        this.services = services;
    }

    public List<Bin> findAll() {
        return dao.findAll();
    }

    public Bin save(Bin input) {
        Bin output = services.constructBin(input);
        return dao.save(output);
    }

    public void update(Bin input, Long id) {
        Bin output = services.constructBin(input, id);
        dao.save(output);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public Bin findById(Long id) {
        return dao.findById(id).orElseThrow();
    }
}
