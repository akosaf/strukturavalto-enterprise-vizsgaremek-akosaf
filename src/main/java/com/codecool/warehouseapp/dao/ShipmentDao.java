package com.codecool.warehouseapp.dao;

import com.codecool.warehouseapp.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentDao extends JpaRepository<Shipment, Long> {
}
