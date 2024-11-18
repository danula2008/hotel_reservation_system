package edu.icet.pms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(generator = "c-generator")
    @GenericGenerator(name = "c-generator",
            strategy = "edu.icet.pms.util.IdGenerator",
            parameters = @Parameter(name = "prefix", value = "C"))
    private String id;
    private String fName;
    private String lName;
    private String gender;
    private LocalDate dob;
    private String contact;
    private String country;
    private String userId;
}
