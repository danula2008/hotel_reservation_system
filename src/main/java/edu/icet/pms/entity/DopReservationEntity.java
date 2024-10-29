package edu.icet.pms.entity;

import edu.icet.pms.util.composite_keys.DopReservationPK;
import jakarta.persistence.*;
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
@Entity
@Table(name = "DopReservation")
@IdClass(DopReservationPK.class)
public class DopReservationEntity {
    @Id
    private String  reservationId;
    @Id
    private String dopId;
    private String eventDescription;
    private String foodRequest;
    private LocalDate date;
    private LocalTime startingTime;
    private LocalTime endingTime;
    private String specialRequests;
}
