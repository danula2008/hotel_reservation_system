package edu.icet.pms.service.impl;

import edu.icet.pms.dao.UserDao;
import edu.icet.pms.dto.User;
import edu.icet.pms.entity.UserEntity;
import edu.icet.pms.service.UserService;
import edu.icet.pms.util.HashPassword;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao repository;
    private final ModelMapper mapper;

    @Override
    public String addUser(User user) {
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity.setPassword(HashPassword.hashPassword(user.getPassword()));
        return repository.save(userEntity).getId();
    }

    @Override
    public void deleteUser(String id){
        repository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll().stream().map(userEntity -> mapper.map(userEntity, User.class)).toList();
    }

    @Override
    public User getUserById(String id) {
        return mapper.map(repository.getReferenceById(id), User.class);
    }

    @Override
    public User getUserByUsername(String username) {
        return mapper.map(repository.getReferenceByUsername(username), User.class);
    }

    @Override
    public User getUserByEmail(String email) {
        return mapper.map(repository.getReferenceByEmail(email), User.class);
    }

    @Override
    public List<User> getUserByRole(String role) {
        return repository.findByRole(role).stream().map(userEntity -> { userEntity.setPassword(null); return mapper.map(userEntity, User.class); }).toList();
    }

    @Override
    public User validateLogin(String email, String username, String password) {
        UserEntity user = repository.findByUsernameOrEmail(email, username);
        if (user != null && HashPassword.verifyPassword(password, user.getPassword())) {
            user.setPassword(null);
            return mapper.map(user, User.class);
        }
        return null;
    }

    @Override
    public Boolean usernameAvailable(String username) {
        return repository.findByUsername(username)==null;
    }
}
