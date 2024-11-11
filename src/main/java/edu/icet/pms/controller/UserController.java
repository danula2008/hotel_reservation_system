package edu.icet.pms.controller;

import edu.icet.pms.dto.User;
import edu.icet.pms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody User user){
        return String.format("User successfully saved with ID: %s.", service.addUser(user));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String updateUser(@RequestBody User user){
        service.addUser(user);
        return "User successfully updated.";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteUser(@PathVariable String id){
        service.deleteUser(id);
        return "User successfully deleted.";
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/get/id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public User getUserById(@PathVariable String id){
        return service.getUserById(id);
    }

    @GetMapping("/get/username/{username}")
    @ResponseStatus(HttpStatus.FOUND)
    public User getUserByUsername(@PathVariable String username){
        return service.getUserByUsername(username);
    }

    @GetMapping("/get/email/{email}")
    @ResponseStatus(HttpStatus.FOUND)
    public User getUserByEmail(@PathVariable String email){
        return service.getUserByEmail(email);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.FOUND)
    public List<User> getUserByRole(@RequestParam String role){
        return service.getUserByRole(role);
    }
}
