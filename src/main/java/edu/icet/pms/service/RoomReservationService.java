package edu.icet.pms.service;

import edu.icet.pms.dto.RoomReservation;
import edu.icet.pms.util.composite_keys.RoomReservationPK;
import java.util.List;

public interface RoomReservationService {
    void addRoomReservation(RoomReservation roomReservation);
    void deleteRoomReservation(RoomReservationPK id);
    List<RoomReservation> getAllRoomReservations();
    RoomReservation getRoomReservationByReservationId(String id);
    List<RoomReservation> getRoomReservationByRoomId(String roomId);
}
