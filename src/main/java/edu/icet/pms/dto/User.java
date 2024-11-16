package edu.icet.pms.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String role;
    private LocalDateTime dateCreated;
    private LocalDateTime lastLogin;
}
