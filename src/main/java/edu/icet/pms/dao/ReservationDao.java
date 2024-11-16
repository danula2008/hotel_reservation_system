package edu.icet.pms.dao;

import edu.icet.pms.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDao extends JpaRepository<ReservationEntity, String> {
}
