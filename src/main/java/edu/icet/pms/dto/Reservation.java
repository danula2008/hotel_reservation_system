package edu.icet.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private String id;
    private String customerId;
    private Double totPrice;
    private Double discount;
    private String status;
    private Integer noMembers;
    private String paymentMethod;
    private LocalDateTime createdDateTime;
}
