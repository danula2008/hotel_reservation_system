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
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "room-id-generator")
    @GenericGenerator(
            name = "room-id-generator",
            parameters = @Parameter(name = "prefix", value = "R"),
            strategy = "edu.icet.pms.util.IdGenerator"
    )
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
