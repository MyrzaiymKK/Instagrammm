package peaksoft.repository;

import peaksoft.entity.User;

import java.util.List;

public interface UserRepository {

    String saveUser (User newUser);
    User findUserById(Long id);
    String updateUserById(Long id,User newUser);
    List<User> getAllUsers();
    void deleteUserById(Long id);
}
