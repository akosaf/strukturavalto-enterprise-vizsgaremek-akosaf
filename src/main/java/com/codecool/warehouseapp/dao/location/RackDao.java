package com.codecool.warehouseapp.dao.location;

import com.codecool.warehouseapp.model.location.Rack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackDao extends JpaRepository<Rack, Long> {
}
