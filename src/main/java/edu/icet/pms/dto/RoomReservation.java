package edu.icet.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomReservation {
    private String reservationId;
    private String roomID;
    private LocalDate arrivalDate;
    private String arrivalSession;
    private LocalDate departureDate;
    private String departureSession;
    private String specialRequests;
}
