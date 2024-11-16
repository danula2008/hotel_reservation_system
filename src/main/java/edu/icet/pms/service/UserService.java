package edu.icet.pms.service;

import edu.icet.pms.dto.User;

import java.util.List;

public interface UserService {
    String addUser(User user);
    void deleteUser(String id);
    List<User> getAllUsers();
    User getUserById(String id);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    List<User> getUserByRole(String role);
    User validateLogin(String email, String username, String password);
    Boolean usernameAvailable(String username);
}
