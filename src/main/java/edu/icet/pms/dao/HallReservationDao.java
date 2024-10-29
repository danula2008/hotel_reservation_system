package edu.icet.pms.dao;

import edu.icet.pms.entity.HallReservationEntity;
import edu.icet.pms.util.composite_keys.HallReservationPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HallReservationDao extends JpaRepository<HallReservationEntity, HallReservationPK> {
    List<HallReservationEntity> findByReservationId(String id);
    List<HallReservationEntity> findByHallId(String hallId);
    List<HallReservationEntity> findByStartingDate(LocalDate date);
    List<HallReservationEntity> findByEndingDate(LocalDate date);
}
