package edu.icet.pms.service;

import edu.icet.pms.model.ReservationDate;
import edu.icet.pms.model.ReservationDateForPost;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDateService {
    void addReservationDate(ReservationDateForPost reservationDateForPost);
    void deleteReservationDate(String reservationId);
    ReservationDate getReservationDateByReservationId(String reservationId);
    List<ReservationDate> getReservationDateResourceId(String resourceId);
    List<ReservationDate> getAllReservationDates();
    Boolean checkAvailability(String resourceId, LocalDate[] dates);
}
