package edu.icet.pms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String id;
    private String fName;
    private String lName;
    private String gender;
    private LocalDate dob;
    private String contact;
    private String country;
    private String userId;
}

