package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.SupplierDao;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    private final SupplierDao dao;

    public SupplierService(SupplierDao dao) {
        this.dao = dao;
    }
}
