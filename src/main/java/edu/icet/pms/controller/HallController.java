package edu.icet.pms.controller;

import edu.icet.pms.dto.Hall;
import edu.icet.pms.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hall")
@RequiredArgsConstructor
public class HallController {

    private final HallService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addHall(@RequestBody Hall hall){
        return String.format("Hall successfully saved with ID: %s.", service.addHall(hall));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateHall(@RequestBody Hall hall){
        service.addHall(hall);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteHall(@PathVariable String id){
        service.deleteHall(id);
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Hall> getAllHalls(){
        return service.getAllHalls();
    }

    @GetMapping("/get/id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Hall getHallById(@PathVariable String id){
        return service.getHallById(id);
    }

    @GetMapping("/get/type/{type}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Hall> getHallsByType(@PathVariable String type){
        return service.getHallsByType(type);
    }

    @GetMapping("/get/capacity/{capacity}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Hall> getHallsByCapacity(@PathVariable Integer capacity){
        return service.getHallsByCapacity(capacity);
    }

    @GetMapping("/get/internet/{internetAccess}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Hall> getHallsByInternetAccess(@PathVariable Boolean internetAccess){
        return service.getHallsByInternetAccess(internetAccess);
    }

    @GetMapping("/get/climate-control/{climateControl}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Hall> getHallsByClimateControl(@PathVariable Boolean climateControl){
        return service.getHallsByClimateControl(climateControl);
    }

    @GetMapping("/get/decorator-style/{decoratorStyle}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Hall> getHallsByDecoratorStyle(@PathVariable String decoratorStyle){
        return service.getHallsByDecoratorStyle(decoratorStyle);
    }

    @GetMapping("/get/status/{status}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Hall> getHallsByStatus(@PathVariable String status){
        return service.getHallsByStatus(status);
    }
}
