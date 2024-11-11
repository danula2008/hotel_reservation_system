package edu.icet.pms.controller;

import edu.icet.pms.dto.Room;
import edu.icet.pms.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addRoom(@RequestBody Room room){
        return String.format("Room successfully saved with ID: %s.", service.addRoom(room));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateRoom(@RequestBody Room room){
        service.addRoom(room);
        return "Room successfully updated.";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteRoom(@PathVariable String id){
        service.deleteRoom(id);
        return "Room successfully deleted.";
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Room> getAllRooms(){
        return service.getAllRooms();
    }

    @GetMapping("/get/id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Room getRoomById(@PathVariable String id){
        return service.getRoomById(id);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Room> getRoomsByFiltering(@RequestParam(required = false) String type,
                                     @RequestParam(required = false) String capacity,
                                     @RequestParam(required = false) String bedType,
                                     @RequestParam(required = false) String view,
                                     @RequestParam(required = false) String internetAccess,
                                     @RequestParam(required = false) String television,
                                     @RequestParam(required = false) String rating,
                                     @RequestParam(required = false) String available
                                     ){
        return service.getRoomsByFiltering(type,
                capacity == null? null : Integer.getInteger(capacity),
                bedType,
                view,
                internetAccess == null? null : Boolean.parseBoolean(capacity),
                television == null? null : Boolean.parseBoolean(television),
                rating == null? null : Integer.parseInt(rating),
                available == null? null : Boolean.parseBoolean(available));
    }
}
