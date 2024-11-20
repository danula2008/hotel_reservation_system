package edu.icet.pms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Stat {
    private LocalDateTime dateTime;
    private List<Long> totalsOfResources;
    private List<ReservationDate> resourcesBookedToday;
    private List<Reservation> reservationsToday;
    private List<Integer> roomReservationsInMonthRange;
    private List<Integer> hallReservationsInMonthRange;
    private List<Integer> dopReservationsInMonthRange;
    private Long noCustomers;
}
