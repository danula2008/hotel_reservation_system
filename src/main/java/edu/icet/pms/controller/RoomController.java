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

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addRoom(@RequestBody Room room){
        return String.format("Room successfully saved with ID: %s.", service.addRoom(room));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateRoom(@RequestBody Room room){
        service.addRoom(room);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteRoom(@PathVariable String id){
        service.deleteRoom(id);
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

    @GetMapping("/get/type/{type}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Room> getRoomsByType(@PathVariable String type){
        return service.getRoomsByType(type);
    }

    @GetMapping("/get/capacity/{capacity}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Room> getRoomsByCapacity(@PathVariable Integer capacity){
        return service.getRoomsByCapacity(capacity);
    }

    @GetMapping("/get/bed/{bedType}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Room> getRoomsByBedType(@PathVariable String bedType){
        return service.getRoomsByBedType(bedType);
    }

    @GetMapping("/get/view/{view}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Room> getRoomsByView(@PathVariable String view){
        return service.getRoomsByView(view);
    }

    @GetMapping("/get/internet/{internetAccess}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Room> getRoomsByInternetAccess(@PathVariable Boolean internetAccess){
        return service.getRoomsByInternetAccess(internetAccess);
    }

    @GetMapping("/get/television/{television}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Room> getRoomsByTelevision(@PathVariable Boolean television){
        return service.getRoomsByTelevision(television);
    }

    @GetMapping("/get/status/{status}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Room> getRoomsByStatus(@PathVariable String status){
        return service.getRoomsByStatus(status);
    }
}
