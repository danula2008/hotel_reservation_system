package edu.icet.pms.service;

import edu.icet.pms.dto.HallReservation;
import edu.icet.pms.util.composite_keys.HallReservationPK;

import java.time.LocalDate;
import java.util.List;

public interface HallReservationService {
    void addHallReservation(HallReservation hallReservation);
    void deleteHallReservation(HallReservationPK hallReservationPK);
    List<HallReservation> getAllHallReservations();
    List<HallReservation> getHallReservationByReservationId(String id);
    List<HallReservation> getHallReservationByHallId(String hallId);
    List<HallReservation> getHallReservationByStartingDate(LocalDate date);
    List<HallReservation> getHallReservationByEndingDate(LocalDate date);
}
