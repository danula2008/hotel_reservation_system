package edu.icet.pms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "reservation-id-generator")
    @GenericGenerator(
            name = "reservation-id-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "RES"),
            strategy = "edu.icet.pms.util.IdGenerator"
    )
    private String id;
    private String customerId;
    private Double totPrice;
    private Double discount;
    private String status;
    private Integer noMembers;
    private String paymentMethod;
    private LocalDateTime createdDateTime;
}
