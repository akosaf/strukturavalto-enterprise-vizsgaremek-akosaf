package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.CategoryDao;
import com.codecool.warehouseapp.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryDao dao;
    private final WarehouseService services;

    public CategoryService(CategoryDao dao, WarehouseService services) {
        this.dao = dao;
        this.services = services;
    }

    public List<Category> findAll() {
        return dao.findAll();
    }

    public Category save(Category input) {
        Category output = services.constructCategory(input);
        return dao.save(output);
    }

    public void update(Category input, Long id) {
        Category output = services.constructCategory(input, id);
        dao.save(output);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public Category findById(Long id) {
        return dao.findById(id).orElseThrow();
    }
}
