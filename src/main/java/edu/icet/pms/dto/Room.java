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
    private Integer capacity;
    private Double price;
    private String features;
    private String bedType;
    private String view;
    private Boolean internetAccess;
    private Boolean television;
    private String status;
}
