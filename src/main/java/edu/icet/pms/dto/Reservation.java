package edu.icet.pms.dto;

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
public class Reservation {
    private String id;
    private String customerId;
    private Double totPrice;
    private String status;
    private Integer noMembers;
    private Boolean paymentCompleted;
    private LocalDate createdDate;
    private LocalTime createdTime;
    private String specialRequests;
}
