package com.codecool.warehouseapp.dao.location;

import com.codecool.warehouseapp.model.location.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfDao extends JpaRepository<Shelf, Long> {
}
