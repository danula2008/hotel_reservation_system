package edu.icet.pms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DayOutPackage")
public class DayOutPackageEntity {
    @Id
    @GeneratedValue(generator = "dop-generator")
    @GenericGenerator(name = "dop-generator",
            strategy = "edu.icet.pms.util.IdGenerator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "DOP"))
    private String id;
    private String name;
    private String description;
    private String duration;
    private Double price;
    private String inclusion;
    private String equipments;
    private String ageLimit;
    private String timeOfDay;
    private String foodDetails;
    private String groupSize;
    private String image;
    private Integer rating;
    private Boolean available;
}
