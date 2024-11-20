package edu.icet.pms.service;

import edu.icet.pms.model.DopReservation;
import edu.icet.pms.util.composite_keys.DopReservationPK;
import java.util.List;

public interface DopReservationService {
    void addDopReservation(DopReservation dopReservation);
    void deleteDopReservation(DopReservationPK dopReservationPK);
    List<DopReservation> getAllDopReservations();
    DopReservation getDopReservationByReservationId(String id);
    List<DopReservation> getDopReservationByDopId(String dopId);
}
