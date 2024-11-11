package edu.icet.pms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Blob;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "room-id-generator")
    @GenericGenerator(
            name = "room-id-generator",
            parameters = @Parameter(name = "prefix", value = "R"),
            strategy = "edu.icet.pms.util.IdGenerator"
    )
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
    @Lob
    private Blob image;
    private Integer rating;
    private Boolean available;
}
