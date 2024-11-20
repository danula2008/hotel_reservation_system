package edu.icet.pms.service;

import edu.icet.pms.model.HallReservation;
import edu.icet.pms.util.composite_keys.HallReservationPK;
import java.util.List;

public interface HallReservationService {
    void addHallReservation(HallReservation hallReservation);
    void deleteHallReservation(HallReservationPK hallReservationPK);
    List<HallReservation> getAllHallReservations();
    HallReservation getHallReservationByReservationId(String id);
    List<HallReservation> getHallReservationByHallId(String hallId);
}
