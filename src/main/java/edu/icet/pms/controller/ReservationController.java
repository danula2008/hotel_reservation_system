package edu.icet.pms.controller;

import edu.icet.pms.dto.Reservation;
import edu.icet.pms.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {
    
    private final ReservationService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addReservation(@RequestBody Reservation reservation){
        return String.format("Reservation successfully saved with ID: %s.", service.addReservation(reservation));
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
    @ResponseStatus(HttpStatus.FOUND)
    public List<Reservation> getAllReservations(){
        return service.getAllReservations();
    }

    @GetMapping("/get/id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Reservation getReservationById(@PathVariable String id){
        return service.getReservationById(id);
    }

    @GetMapping("/get/customer-id/{customerId}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Reservation> getReservationsByCustomerID(@PathVariable String customerId){
        return service.getReservationsByCustomerID(customerId);
    }

    @GetMapping("/get/status/{status}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Reservation> getReservationsByStatus(@PathVariable String status){
        return service.getReservationsByStatus(status);
    }

    @GetMapping("/get/payment-method/{paymentMethod}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Reservation> getReservationsByPaymentMethod(@PathVariable String paymentMethod){
        return service.getReservationsByPaymentMethod(paymentMethod);
    }
}
