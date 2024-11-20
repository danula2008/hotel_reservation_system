package edu.icet.pms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hall {
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
    private String available;
}
