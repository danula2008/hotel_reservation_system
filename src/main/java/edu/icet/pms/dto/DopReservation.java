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
public class DopReservation {
    private String reservationId;
    private String dopId;
    private String eventDescription;
    private String foodRequest;
    private LocalDate date;
    private LocalTime startingTime;
    private LocalTime endingTime;
    private String specialRequests;
}
