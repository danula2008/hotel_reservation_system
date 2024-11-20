package edu.icet.pms.service;

import edu.icet.pms.model.Reservation;
import edu.icet.pms.model.ReservationDate;
import edu.icet.pms.model.Room;

import java.util.List;

public interface ReservationService {
    String addReservation(Reservation reservation);
    void deleteReservation(String id);
    List<Reservation> getAllReservations();
    Reservation getReservationById(String id);
    List<Reservation> getReservationsByFiltering(String status, String customerId, Boolean paymentCompleted, String resourceType);
}
