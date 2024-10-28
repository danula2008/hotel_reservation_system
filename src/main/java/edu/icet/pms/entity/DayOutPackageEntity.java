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
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "dop-id-generator")
    @GenericGenerator(
            name = "dop-id-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "DOP"),
            strategy = "edu.icet.pms.util.IdGenerator"
    )
    private String id;
    private String name;
    private String description;
    private String duration;
    private Double unitPrice;
    private String inclusion;
    private String equipments;
    private String ageLimit;
    private String timeOfDay;
    private String foodDetails;
    private String groupSize;
    private String status;
}
