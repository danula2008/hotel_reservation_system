package edu.icet.pms.dao;

import edu.icet.pms.entity.ReservationDateEntity;
import edu.icet.pms.util.composite_keys.ReservationDatePK;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservationDateDao extends JpaRepository<ReservationDateEntity, ReservationDatePK> {
    void deleteByReservationId(String reservationId);
    ReservationDateEntity findByReservationId(String reservationId);
    List<ReservationDateEntity> findByResourceId(String resourceId);
}
