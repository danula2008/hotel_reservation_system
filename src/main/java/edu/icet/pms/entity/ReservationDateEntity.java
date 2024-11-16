package edu.icet.pms.entity;

import edu.icet.pms.util.composite_keys.ReservationDatePK;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ReservationDate")
@IdClass(ReservationDatePK.class)
public class ReservationDateEntity {
    @Id
    private String resourceId;
    @Id
    private LocalDate date;
    private String reservationId;
}
