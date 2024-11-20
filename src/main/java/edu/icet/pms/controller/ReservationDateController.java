package edu.icet.pms.controller;

import edu.icet.pms.model.ReservationDate;
import edu.icet.pms.model.ReservationDateForPost;
import edu.icet.pms.service.ReservationDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reserve/date")
@RequiredArgsConstructor
@CrossOrigin
public class ReservationDateController {

    private final ReservationDateService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addReservationDate(@RequestBody ReservationDateForPost reservationDateForPost){
        service.addReservationDate(reservationDateForPost);
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

    @GetMapping("check-availability")
    Boolean checkAvailability(@RequestParam String resourceId, @RequestParam LocalDate[] dates){
        return service.checkAvailability(resourceId, dates);
    }

    @GetMapping("/get/all")
    public List<ReservationDate> getAllReservationDates(){
        return service.getAllReservationDates();
    }
}
