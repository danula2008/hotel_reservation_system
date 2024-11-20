package edu.icet.pms.service;

import edu.icet.pms.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void deleteUser(String id);
    List<User> getAllUsers();
    User getUserById(String id);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    List<User> getUserByRole(String role);
    Boolean usernameAvailable(String username);
    User validateLoginByEmail(String email, String password);
    User validateLoginByUsername(String username, String password);
}
