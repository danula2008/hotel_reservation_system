package edu.icet.pms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Room")
public class RoomEntity {
    @Id
    @GeneratedValue(generator = "r-generator")
    @GenericGenerator(name = "r-generator",
            strategy = "edu.icet.pms.util.IdGenerator",
            parameters = @Parameter(name = "prefix", value = "R"))
    private String id;
    private String type;
    private String name;
    private String description;
    private Integer capacity;
    private String features;
    private Double price;
    private String bedType;
    private String view;
    private Boolean internetAccess;
    private Boolean television;
    private String image;
    private Integer rating;
    private Boolean available;
}
