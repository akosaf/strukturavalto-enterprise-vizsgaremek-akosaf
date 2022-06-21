package com.codecool.warehouseapp.dao;

import com.codecool.warehouseapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemDao extends JpaRepository<Item, UUID> {
}
