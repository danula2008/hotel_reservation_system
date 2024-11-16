package edu.icet.pms.dao;

import edu.icet.pms.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserDao extends JpaRepository<UserEntity, String> {
    UserEntity getReferenceByUsername(String username);
    UserEntity getReferenceByEmail(String email);
    List<UserEntity> findByRole(String role);
    UserEntity findByUsernameOrEmail(String email, String username);
    UserEntity findByUsername(String username);
}
