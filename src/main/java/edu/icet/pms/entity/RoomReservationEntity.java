package edu.icet.pms.entity;

import edu.icet.pms.util.composite_keys.RoomReservationPK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RoomReservation")
@IdClass(RoomReservationPK.class)
public class RoomReservationEntity {
    @Id
    private String  reservationId;
    @Id
    private String roomId;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
}
