package edu.icet.pms.dao;

import edu.icet.pms.entity.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallDao extends JpaRepository<HallEntity, String> {
}
