package edu.icet.pms.util.composite_keys;

import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class DopReservationPK implements Serializable {
    private String dopId;
    private String reservationId;
}
