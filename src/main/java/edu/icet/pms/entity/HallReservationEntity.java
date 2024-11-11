package edu.icet.pms.entity;

import edu.icet.pms.util.composite_keys.HallReservationPK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HallReservation")
@IdClass(HallReservationPK.class)
public class HallReservationEntity {
    @Id
    private String  reservationId;
    @Id
    private String hallId;
    private String eventDescription;
    private String foodRequests;
    private LocalTime startingTime;
    private LocalTime endingTime;
}
