package edu.icet.pms.controller;

import edu.icet.pms.dto.DayOutPackage;
import edu.icet.pms.service.DayOutPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dop")
@RequiredArgsConstructor
public class DayOutPackageController {

    private final DayOutPackageService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addDop(@RequestBody DayOutPackage dop){
        return String.format("Day Out Package successfully saved with ID: %s.", service.addDop(dop));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateDop(@RequestBody DayOutPackage dop){
        service.addDop(dop);
        return "Day Out Package successfully updated.";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteDop(@PathVariable String id){
        service.deleteDop(id);
        return "Day Out Package successfully deleted.";
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<DayOutPackage> getAllDop(){
        return service.getAllDop();
    }

    @GetMapping("/get/id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public DayOutPackage getDopById(@PathVariable String id){
        return service.getDopById(id);
    }

    @GetMapping("/get/duration/{duration}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<DayOutPackage> getDopByDuration(@PathVariable String duration){
        return service.getDopByDuration(duration);
    }

    @GetMapping("/get/time-of-day/{timeOfDay}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<DayOutPackage> getDopByTimeOfDay(@PathVariable String timeOfDay){
        return service.getDopByTimeOfDay(timeOfDay);
    }

    @GetMapping("/get/status/{status}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<DayOutPackage> getDopByStatus(@PathVariable String status){
        return service.getDopByStatus(status);
    }
}
