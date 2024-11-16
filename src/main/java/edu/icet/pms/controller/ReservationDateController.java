package edu.icet.pms.controller;

import edu.icet.pms.dto.ReservationDate;
import edu.icet.pms.service.ReservationDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserve/date")
@RequiredArgsConstructor
@CrossOrigin
public class ReservationDateController {

    private final ReservationDateService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addReservationDate(@RequestBody ReservationDate reservationDate){
        service.addReservationDate(reservationDate);
    }

    @DeleteMapping("/{reservationId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteReservationDate(@PathVariable String reservationId){
        service.deleteReservationDate(reservationId);
    }

    @GetMapping("/{reservationId}")
    public ReservationDate getReservationDateByReservationId(@PathVariable String reservationId){
        return service.getReservationDateByReservationId(reservationId);
    }

    @GetMapping("/{resourceId}")
    public List<ReservationDate> getReservationDateResourceId(@PathVariable String resourceId){
        return service.getReservationDateResourceId(resourceId);
    }

    @GetMapping("/get/all")
    public List<ReservationDate> getAllReservationDates(){
        return service.getAllReservationDates();
    }
}
