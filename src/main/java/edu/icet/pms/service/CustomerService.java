package edu.icet.pms.service;

import edu.icet.pms.dto.Customer;

import java.util.List;

public interface CustomerService {
    String addCustomer(Customer customer);
    void deleteCustomer(String id);
    List<Customer> getAllCustomers();
    Customer getCustomerById(String id);
    List<Customer> getCustomersByGender(String gender);
    Customer getCustomersByUserId(String userId);
}
