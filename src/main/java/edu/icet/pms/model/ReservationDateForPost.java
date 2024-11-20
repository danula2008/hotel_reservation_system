package edu.icet.pms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDateForPost {
    private String reservationId;
    private String resourceId;
    private LocalDate[] dates;
}
