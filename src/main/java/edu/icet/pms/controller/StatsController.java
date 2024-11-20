package edu.icet.pms.controller;

import edu.icet.pms.model.Stat;
import edu.icet.pms.service.StatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
@RequiredArgsConstructor
@CrossOrigin
public class StatsController {

    private final StatService service;

    @GetMapping
    public Stat getStats(){
        return service.getStats();
    }

}
