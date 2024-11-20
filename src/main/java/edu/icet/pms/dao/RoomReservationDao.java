package edu.icet.pms.dao;

import edu.icet.pms.entity.RoomReservationEntity;
import edu.icet.pms.util.composite_keys.RoomReservationPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RoomReservationDao extends JpaRepository<RoomReservationEntity, RoomReservationPK> {
    RoomReservationEntity findByReservationId(String id);
    List<RoomReservationEntity> findByRoomId(String roomId);
    List<RoomReservationEntity>  findByArrivalDateLessThanEqualAndDepartureDateGreaterThanEqual(LocalDate now, LocalDate now1);
}
