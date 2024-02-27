package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.contoller.UserController;
import peaksoft.entity.Follower;
import peaksoft.entity.User;
import peaksoft.entity.UserInfo;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserInfoService;
import peaksoft.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User sigUp(User newUser) {
        UserInfo userInfo = new UserInfo();
        Follower follower = new Follower();
        newUser.setUserInfo(userInfo);
        newUser.setFollower(follower);
        userInfo.setUser(newUser);
        follower.setUser(newUser);
        userRepository.sigUp(newUser);
      return  userRepository.signIn(newUser.getUserName(), newUser.getPassword());
    }

    @Override
    public User signIn(String userName, String password) {
        return userRepository.signIn(userName, password);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User findUserByUserName(String userName) throws Exception {
        User foundUser = userRepository.findUserByUserName(userName);
        if (foundUser.getUserName().equalsIgnoreCase(UserController.currentUser.getUserName())){
            throw new Exception();
        }
        return foundUser;
    }

    @Override
    public String updateUserById(Long id, User newUser) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
       return userRepository.getAllUsers();
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    @Transactional
    public void addFollower(Long foundUserId) {
        Long userId = UserController.currentUser.getId();
        User currentUser = findUserById(userId);
        User foundUser = findUserById(foundUserId);

        if (currentUser != null && foundUser != null){
            List<Long> subscription = currentUser.getFollower().getSubscription();
            List<Long> subscribers = foundUser.getFollower().getSubscribers();

            if (subscription.contains(foundUserId)){
                subscription.remove(foundUserId);
                subscribers.remove(userId);
            }else {
                subscription.add(foundUserId);
                subscribers.add(userId);
            }
        }
    }
}
