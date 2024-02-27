package peaksoft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.User;

import java.util.List;


public interface UserService {
    User sigUp (User newUser);
    User signIn(String userName,String password);
    User findUserById(Long id);
    User findUserByUserName(String userName) throws Exception;
    String updateUserById(Long id,User newUser);
    List<User> getAllUsers();
    void deleteUserById(Long id);
    void addFollower(Long foundUserId);
}
