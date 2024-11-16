package edu.icet.pms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "customer-id-generator")
    @GenericGenerator(
            name = "customer-id-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "C"),
            strategy = "edu.icet.pms.util.IdGenerator"
    )
    private String id;
    private String fName;
    private String lName;
    private String gender;
    private LocalDate dob;
    private String contact;
    private String country;
    private String userId;
}
