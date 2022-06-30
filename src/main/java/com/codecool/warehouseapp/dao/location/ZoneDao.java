package com.codecool.warehouseapp.dao.location;

import com.codecool.warehouseapp.model.location.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneDao extends JpaRepository<Zone, Long> {
}
