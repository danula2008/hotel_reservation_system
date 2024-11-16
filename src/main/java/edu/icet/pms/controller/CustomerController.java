package edu.icet.pms.controller;

import edu.icet.pms.dto.Customer;
import edu.icet.pms.service.CustomerService;
import edu.icet.pms.util.ResponseMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> addCustomer(@RequestBody Customer customer){
        return ResponseMapping.getMapping("Customer successfully saved with ID: %s.".formatted(service.addCustomer(customer)));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> updateCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
        return ResponseMapping.getMapping("Customer successfully updated.");
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String, String> deleteCustomer(@PathVariable String id){
        service.deleteCustomer(id);
        return ResponseMapping.getMapping("Customer successfully deleted.");
    }

    @GetMapping("/get/all")
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

    @GetMapping("/get/id/{id}")
    public Customer getCustomerById(@PathVariable String id){
        return service.getCustomerById(id);
    }

    @GetMapping("/get/user_id/{userId}")
    public Customer getCustomersByUserId(@PathVariable String userId){
        return service.getCustomersByUserId(userId);
    }

    @GetMapping("/get")
    public List<Customer> getCustomersByGender(@RequestParam String gender){
        return service.getCustomersByGender(gender);
    }
}
