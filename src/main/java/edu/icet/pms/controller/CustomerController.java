package edu.icet.pms.controller;

import edu.icet.pms.dto.Customer;
import edu.icet.pms.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addCustomer(@RequestBody Customer customer){
        return String.format("Customer successfully saved with ID: %s.", service.addCustomer(customer));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCustomer(@PathVariable String id){
        service.deleteCustomer(id);
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

    @GetMapping("/get/id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Customer getCustomerById(@PathVariable String id){
        return service.getCustomerById(id);
    }

    @GetMapping("/get/gender/{gender}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Customer> getCustomersByGender(@PathVariable String gender){
        return service.getCustomersByGender(gender);
    }

    @GetMapping("/get/user-id/{userId}")
    @ResponseStatus(HttpStatus.FOUND)
    public Customer getCustomersByUserId(@PathVariable String userId){
        return service.getCustomersByUserId(userId);
    }

}
