package peaksoft.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import peaksoft.contoller.UserController;
import peaksoft.entity.Like;
import peaksoft.entity.User;
import peaksoft.repository.LikeRepository;
import peaksoft.repository.UserRepository;

@Repository
@RequiredArgsConstructor
public class LikeRepositoryImpl  implements LikeRepository {
    private final UserRepository userRepository;
    @Override
    public void addLike(Long foundUserId) {
//        Long myId = UserController.currentUser.getId();
//        User currentUser = userRepository.findUserById(myId);
//        User foundUser = userRepository.findUserById(foundUserId);
//
//        if(currentUser != null && foundUser != null){
//            Like like = currentUser.getLike().getUser().getLike();
//            Like like1 = foundUser.getLike().getUser().getLike();
//
//            if(like.foundUserId){
//
//            }
//
//        }



    }
}
