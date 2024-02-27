package peaksoft.service;

import peaksoft.entity.User;
import peaksoft.entity.UserInfo;

public interface UserInfoService {
    UserInfo findUserInfoById(Long id);
    UserInfo update(Long id,UserInfo userInfo);
}
