package edu.icet.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

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
    private Blob image;
    private Integer rating;
    private String available;
}
