package edu.icet.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DayOutPackage {
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
