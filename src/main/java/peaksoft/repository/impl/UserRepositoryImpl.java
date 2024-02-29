package peaksoft.repository.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.User;
import peaksoft.entity.UserInfo;
import peaksoft.repository.UserRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public String sigUp(User newUser) {
         entityManager.persist(newUser);
         return "Successfully  saved!";
    }

    @Override
    public User signIn(String userName, String password){
        for (User user : getAllUsers()) {
            if(user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findUserByUserName(String userName) {
        User user  = null;
      user =  entityManager.createQuery("select u from User u where u.userName ilike  (:add)", User.class)
                .setParameter("add",userName)
                .getSingleResult();
        return user;
    }

    @Override
    public String updateUserById(Long id, User newUser) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
      return   entityManager.createQuery("select u from User u",User.class)
                .getResultList();

    }

    @Override
    public void deleteUserById(Long id) {

    }
}
