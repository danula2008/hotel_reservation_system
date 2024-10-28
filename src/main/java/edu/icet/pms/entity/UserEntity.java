package edu.icet.pms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user-id-generator")
    @GenericGenerator(
            name = "user-id-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "U"),
            strategy = "edu.icet.pms.util.IdGenerator"
    )
    private String id;
    private String username;
    private String password;
    private String email;
    private String role;
    private LocalDateTime dateCreated;
    private LocalDateTime lastLogin;
}
