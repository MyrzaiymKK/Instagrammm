package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.contoller.UserController;
import peaksoft.entity.User;
import peaksoft.entity.UserInfo;
import peaksoft.repository.UserInfoRepository;
import peaksoft.service.UserInfoService;

import java.lang.reflect.Field;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository infoRepository;

    @Override
    public UserInfo findUserInfoById(Long id) {
      return infoRepository.findUserInfoById( id);
    }

    @Override
    public UserInfo update(Long id, UserInfo userInfo) {
        UserController.currentUser.setUserInfo(userInfo);
       return infoRepository.update(id,userInfo);
    }
}
