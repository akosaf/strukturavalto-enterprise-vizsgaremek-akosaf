package com.codecool.warehouseapp.dao;

import com.codecool.warehouseapp.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDao extends JpaRepository<Supplier, Long> {
}
