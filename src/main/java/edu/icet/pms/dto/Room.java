package edu.icet.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
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
