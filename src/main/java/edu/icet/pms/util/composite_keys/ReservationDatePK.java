package edu.icet.pms.util.composite_keys;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class ReservationDatePK implements Serializable {
    private String resourceId;
    private LocalDate date;
}
