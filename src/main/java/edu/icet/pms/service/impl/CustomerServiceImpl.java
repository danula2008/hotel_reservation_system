package edu.icet.pms.service.impl;

import edu.icet.pms.dao.CustomerDao;
import edu.icet.pms.dto.Customer;
import edu.icet.pms.entity.CustomerEntity;
import edu.icet.pms.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao repository;
    private final ModelMapper mapper;

    @Override
    public String addCustomer(Customer customer) {
        return repository.save(mapper.map(customer, CustomerEntity.class)).getId();
    }

    @Override
    public void deleteCustomer(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll().stream().map(customerEntity -> mapper.map(customerEntity, Customer.class)).toList();
    }

    @Override
    public Customer getCustomerById(String id) {
        return mapper.map(repository.getReferenceById(id), Customer.class);
    }

    @Override
    public List<Customer> getCustomersByGender(String gender) {
        return repository.findByGender(gender).stream().map(customerEntity -> mapper.map(customerEntity, Customer.class)).toList();
    }

    @Override
    public Customer getCustomersByUserId(String userId) {
        return mapper.map(repository.findByUserId(userId), Customer.class);
    }
}
