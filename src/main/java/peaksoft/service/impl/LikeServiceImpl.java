package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Post;
import peaksoft.repository.UserRepository;
import peaksoft.service.LikeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final PostServiceImpl postService;
    private final UserRepository userRepository;

    @Override
    public void addLikes(Long foundUserId, Long postId) {
        Post post = postService.findPostById(postId);

        List<Long> postLike = post.getLike().getPostLike();

        if (postLike.contains(foundUserId)){
            postLike.remove(foundUserId);
        }else {
            postLike.add(foundUserId);
        }
    }
}
