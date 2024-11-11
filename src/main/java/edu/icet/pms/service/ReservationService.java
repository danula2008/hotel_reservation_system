package edu.icet.pms.service;

import edu.icet.pms.dto.Reservation;
import edu.icet.pms.dto.Room;

import java.util.List;

public interface ReservationService {
    String addReservation(Reservation reservation);
    void deleteReservation(String id);
    List<Reservation> getAllReservations();
    Reservation getReservationById(String id);
    List<Room> getReservationsByFiltering(String status, String customerId, Boolean paymentCompleted);
}
