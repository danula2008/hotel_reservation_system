package edu.icet.pms.service;

import edu.icet.pms.dto.Reservation;

import java.util.List;

public interface ReservationService {
    String addReservation(Reservation reservation);
    void deleteReservation(String id);
    List<Reservation> getAllReservations();
    Reservation getReservationById(String id);
    List<Reservation> getReservationsByCustomerID(String customerId);
    List<Reservation> getReservationsByStatus(String status);
    List<Reservation> getReservationsByPaymentMethod(String paymentMethod);
}
