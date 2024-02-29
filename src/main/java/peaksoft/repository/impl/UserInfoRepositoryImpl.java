package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.UserInfo;
import peaksoft.repository.UserInfoRepository;

@Repository
@RequiredArgsConstructor
@Transactional
public class UserInfoRepositoryImpl  implements UserInfoRepository {

    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public UserInfo findUserInfoById(Long id) {
       return entityManager.find(UserInfo.class,id);
    }

    @Override
    public UserInfo update(Long id,UserInfo userInfo) {
        UserInfo currentUser = findUserInfoById(id);
        currentUser.setBiography(userInfo.getBiography());
        currentUser.setFullName(userInfo.getFullName());
        currentUser.setGender(userInfo.getGender());
        currentUser.setImage(userInfo.getImage());
        entityManager.merge(currentUser);
        return userInfo;
    }
}
