package com.codecool.warehouseapp.dao;

import com.codecool.warehouseapp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao extends JpaRepository<Stock, Long> {
}
