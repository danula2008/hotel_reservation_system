package edu.icet.pms.service;

import edu.icet.pms.dto.ReservationDate;

import java.util.List;

public interface ReservationDateService {
    void addReservationDate(ReservationDate reservationDate);
    void deleteReservationDate(String reservationId);
    ReservationDate getReservationDateByReservationId(String reservationId);
    List<ReservationDate> getReservationDateResourceId(String resourceId);
    List<ReservationDate> getAllReservationDates();
}
