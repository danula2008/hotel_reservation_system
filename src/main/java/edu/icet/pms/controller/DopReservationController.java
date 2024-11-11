package edu.icet.pms.controller;

import edu.icet.pms.dto.DopReservation;
import edu.icet.pms.service.DopReservationService;
import edu.icet.pms.util.composite_keys.DopReservationPK;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reserve/dop")
@RequiredArgsConstructor
public class DopReservationController {

    private final DopReservationService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addDopReservation(@RequestBody DopReservation dopReservation){
        service.addDopReservation(dopReservation);
        return "Day Out Package Reservation successfully saved.";
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateDopReservation(@RequestBody DopReservation dopReservation){
        service.addDopReservation(dopReservation);
        return "Day Out Package Reservation successfully updated.";
    }

    @DeleteMapping("/delete/{reservationId}/{dopId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteDopReservation(@PathVariable String reservationId, @PathVariable String dopId){
        service.deleteDopReservation(new DopReservationPK(dopId, reservationId));
        return "Day Out Package Reservation successfully deleted.";
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<DopReservation> getAllDopReservations(){
        return service.getAllDopReservations();
    }

    @GetMapping("/get/id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public DopReservation getDopReservationById(@PathVariable String id){
        return service.getDopReservationByReservationId(id);
    }

    @GetMapping("/get/dop-id/{dopId}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<DopReservation> getDopReservationByDopId(@PathVariable String dopId){
        return service.getDopReservationByDopId(dopId);
    }
}
