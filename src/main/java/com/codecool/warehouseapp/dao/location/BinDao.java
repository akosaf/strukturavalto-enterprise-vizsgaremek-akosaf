package com.codecool.warehouseapp.dao.location;

import com.codecool.warehouseapp.model.location.Bin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinDao extends JpaRepository<Bin, Long> {
}
