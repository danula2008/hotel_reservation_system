package edu.icet.pms.controller;

import edu.icet.pms.dto.Hall;
import edu.icet.pms.service.HallService;
import edu.icet.pms.util.ResponseMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hall")
@RequiredArgsConstructor
@CrossOrigin
public class HallController {

    private final HallService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> addHall(@RequestBody Hall hall) {
        return ResponseMapping.getMapping("Hall successfully saved with ID: %s.".formatted(service.addHall(hall)));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String, String> updateHall(@RequestBody Hall hall) {
        service.addHall(hall);
        return ResponseMapping.getMapping("Hall successfully updated.");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String, String> deleteHall(@PathVariable String id) {
        service.deleteHall(id);
        return ResponseMapping.getMapping("Hall successfully deleted.");
    }

    @GetMapping("/get/all")
    public List<Hall> getAllHalls() {
        return service.getAllHalls();
    }

    @GetMapping("/get/id/{id}")
    public Hall getHallById(@PathVariable String id) {
        return service.getHallById(id);
    }

    @GetMapping("/get")
    public List<Hall> getHallsByFiltering(@RequestParam(required = false) String type,
                                     @RequestParam(required = false) String capacity,
                                     @RequestParam(required = false) String internetAccess,
                                     @RequestParam(required = false) String climateControl,
                                     @RequestParam(required = false) String decoratorStyle,
                                     @RequestParam(required = false) String rating,
                                     @RequestParam(required = false) String available
    ) {
        return service.getHallsByFiltering(type,
                capacity == null? null : Integer.getInteger(capacity),
                internetAccess == null? null : Boolean.parseBoolean(internetAccess),
                climateControl == null? null : Boolean.parseBoolean(climateControl),
                decoratorStyle == null? null : Boolean.parseBoolean(decoratorStyle),
                rating == null? null : Integer.parseInt(rating),
                available == null? null : Boolean.parseBoolean(available));
    }
}
