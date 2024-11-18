package edu.icet.pms.controller;

import edu.icet.pms.dto.Reservation;
import edu.icet.pms.dto.Room;
import edu.icet.pms.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
@CrossOrigin
public class ReservationController {
    
    private final ReservationService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addReservation(@RequestBody Reservation reservation){
        return service.addReservation(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateReservation(@RequestBody Reservation reservation){
        service.addReservation(reservation);
        return "Reservation successfully updated.";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteReservation(@PathVariable String id){
        service.deleteReservation(id);
        return "Reservation successfully deleted.";
    }

    @GetMapping("/get/all")
    public List<Reservation> getAllReservations(){
        return service.getAllReservations();
    }

    @GetMapping("/get/id/{id}")
    public Reservation getReservationById(@PathVariable String id){
        return service.getReservationById(id);
    }

    @GetMapping("/get")
    public List<Room> getReservationsByFiltering(@RequestParam(required = false) String status,
                                                 @RequestParam(required = false) String customerId,
                                                 @RequestParam(required = false) String paymentCompleted
    ){
        return service.getReservationsByFiltering(
                status,
                customerId,
                paymentCompleted == null? null : Boolean.parseBoolean(paymentCompleted));
    }
}
