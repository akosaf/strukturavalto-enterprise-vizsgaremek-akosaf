package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.CategoryDao;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryDao dao;

    public CategoryService(CategoryDao dao) {
        this.dao = dao;
    }
}
