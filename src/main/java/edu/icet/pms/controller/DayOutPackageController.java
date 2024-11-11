package edu.icet.pms.controller;

import edu.icet.pms.dto.DayOutPackage;
import edu.icet.pms.service.DayOutPackageService;
import edu.icet.pms.util.ResponseMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dop")
@RequiredArgsConstructor
public class DayOutPackageController {

    private final DayOutPackageService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> addDop(@RequestBody DayOutPackage dop){
        return ResponseMapping.getMapping(("Day Out Package successfully saved with ID: %s.".formatted(service.addDop(dop))));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String, String> updateDop(@RequestBody DayOutPackage dop){
        service.addDop(dop);
        return ResponseMapping.getMapping("Day Out Package successfully updated.");
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String, String> deleteDop(@PathVariable String id){
        service.deleteDop(id);
        return ResponseMapping.getMapping("Day Out Package successfully deleted.");
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

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.FOUND)
    public List<DayOutPackage> getDopByFiltering(@RequestParam(required = false) String duration,
                                                @RequestParam(required = false) String timeOfDay,
                                                @RequestParam(required = false) String rating,
                                                @RequestParam(required = false) String available){
        return service.getDopByFiltering(duration,
                timeOfDay,
                rating==null? null : Integer.parseInt(rating),
                available==null? null : Boolean.parseBoolean(available));
    }
}
