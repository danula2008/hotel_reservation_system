package edu.icet.pms.service;

import edu.icet.pms.dto.DopReservation;
import edu.icet.pms.util.composite_keys.DopReservationPK;

import java.time.LocalDate;
import java.util.List;

public interface DopReservationService {
    void addDopReservation(DopReservation dopReservation);
    void deleteDopReservation(DopReservationPK dopReservationPK);
    List<DopReservation> getAllDopReservations();
    List<DopReservation> getDopReservationByReservationId(String id);
    List<DopReservation> getDopReservationByDopId(String dopId);
    List<DopReservation> getDopReservationByStartingDate(LocalDate date);
}
