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
public class RoomReservation {
    private String  reservationId;
    private String roomId;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
}
