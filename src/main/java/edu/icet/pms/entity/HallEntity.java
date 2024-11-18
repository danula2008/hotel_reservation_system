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
@Table(name = "Hall")
public class HallEntity {
    @Id
    @GeneratedValue(generator = "h-generator")
    @GenericGenerator(name = "h-generator",
            strategy = "edu.icet.pms.util.IdGenerator",
            parameters = @Parameter(name = "prefix", value = "H"))
    private String id;
    private String name;
    private String description;
    private String type;
    private Integer capacity;
    private Double price;
    private String availEquip;
    private Boolean internetAccess;
    private Boolean climateControl;
    private String decoratorStyle;
    private String image;
    private Integer rating;
    private Boolean available;
}
