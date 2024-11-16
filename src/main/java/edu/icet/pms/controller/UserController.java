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
@CrossOrigin
public class UserController {

    private final UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody User user){
        return service.addUser(user);
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
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/get/id/{id}")
    public User getUserById(@PathVariable String id){
        return service.getUserById(id);
    }

    @GetMapping("/get/username/{username}")
    public User getUserByUsername(@PathVariable String username){
        return service.getUserByUsername(username);
    }

    @GetMapping("/get/email/{email}")
    public User getUserByEmail(@PathVariable String email){
        return service.getUserByEmail(email);
    }

    @GetMapping("/get")
    public List<User> getUserByRole(@RequestParam String role){
        return service.getUserByRole(role);
    }

    @GetMapping("validate-login")
    public User validateLogin(@RequestParam(required = false) String email,
                             @RequestParam(required = false) String username,
                             @RequestParam String password) {
        return service.validateLogin(email, username, password);
    }

    @GetMapping("username-available/{username}")
    public Boolean usernameAvailable(@PathVariable String username) {
        return service.usernameAvailable(username);
    }
}
