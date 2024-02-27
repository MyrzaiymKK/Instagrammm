package peaksoft.repository;

import peaksoft.entity.User;

import java.util.List;

public interface UserRepository {

    String sigUp (User  newUser);
    User signIn(String userName,String password);
    User findUserById(Long id);
    User findUserByUserName(String userName);
    String updateUserById(Long id,User newUser);
    List<User> getAllUsers();
    void deleteUserById(Long id);
}
