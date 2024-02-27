package peaksoft.repository;

import peaksoft.entity.User;
import peaksoft.entity.UserInfo;

public interface UserInfoRepository {
    UserInfo findUserInfoById(Long id );
    UserInfo update(Long id,UserInfo userInfo);
}
