package edu.icet.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HallReservation {
    private String reservationId;
    private String hallId;
    private String eventDescription;
    private String foodRequests;
    private String decoRequest;
    private LocalDate startingDate;
    private LocalTime startingTime;
    private LocalDate endingDate;
    private LocalTime endingTime;
    private String specialRequests;
}
