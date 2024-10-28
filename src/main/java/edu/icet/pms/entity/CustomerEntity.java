package edu.icet.pms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class CustomerEntity {
    private String id;
    private String fName;
    private String lName;
    private String gender;
    private LocalDate dob;
    private String contact;
    private String address;
    private String userId;
}
