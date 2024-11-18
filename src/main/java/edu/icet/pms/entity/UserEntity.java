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
    @GeneratedValue(generator = "u-generator")
    @GenericGenerator(name = "u-generator",
            strategy = "edu.icet.pms.util.IdGenerator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "U"))
    private String id;
    private String name;
    private String username;
    private byte[] password;
    private String email;
    private String role;
    private LocalDateTime dateCreated;
    private LocalDateTime lastLogin;
}
