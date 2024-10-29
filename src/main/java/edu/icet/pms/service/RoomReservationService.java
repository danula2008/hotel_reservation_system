package edu.icet.pms.service;

import edu.icet.pms.dto.RoomReservation;
import edu.icet.pms.util.composite_keys.RoomReservationPK;

import java.time.LocalDate;
import java.util.List;

public interface RoomReservationService {
    void addRoomReservation(RoomReservation roomReservation);
    void deleteRoomReservation(RoomReservationPK id);
    List<RoomReservation> getAllRoomReservations();
    List<RoomReservation> getRoomReservationByReservationId(String id);
    List<RoomReservation> getRoomReservationByRoomId(String roomId);
    List<RoomReservation> getRoomReservationByArrivalDate(LocalDate date);
    List<RoomReservation> getRoomReservationByDepartureDate(LocalDate date);
}
