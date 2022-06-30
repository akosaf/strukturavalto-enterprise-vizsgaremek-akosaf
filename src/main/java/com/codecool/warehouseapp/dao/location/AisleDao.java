package com.codecool.warehouseapp.dao.location;

import com.codecool.warehouseapp.model.location.Aisle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AisleDao extends JpaRepository<Aisle, Long> {
}
