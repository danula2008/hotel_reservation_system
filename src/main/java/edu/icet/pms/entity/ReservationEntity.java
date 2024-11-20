package edu.icet.pms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(generator = "res-generator")
    @GenericGenerator(name = "res-generator",
            strategy = "edu.icet.pms.util.IdGenerator",
            parameters = @Parameter(name = "prefix", value = "RES"))
    private String id;
    private String customerId;
    private Double totPrice;
    private String status;
    private Integer noMembers;
    private Boolean paymentCompleted;
    private LocalDateTime createdDateTime;
    private String specialRequests;
    private String resourceType;
}
