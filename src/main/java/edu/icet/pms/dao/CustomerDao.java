package edu.icet.pms.dao;

import edu.icet.pms.dto.Customer;
import edu.icet.pms.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface CustomerDao extends JpaRepository<CustomerEntity, String> {
    List<CustomerEntity> findByGender(String gender);
    CustomerEntity findByUserId(String userId);
}
