package edu.icet.pms.dao;

import edu.icet.pms.entity.HallReservationEntity;
import edu.icet.pms.util.composite_keys.HallReservationPK;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HallReservationDao extends JpaRepository<HallReservationEntity, HallReservationPK> {
    HallReservationEntity findByReservationId(String id);
    List<HallReservationEntity> findByHallId(String hallId);
}
