package peaksoft.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Post;
import peaksoft.entity.User;
import peaksoft.service.LikeService;
import peaksoft.service.PostService;
import peaksoft.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Like")
public class LikeController {
    private final LikeService likeService;
    private final UserService userService;
    private final PostService postService;

    @GetMapping("/likeClick/{userId}/{postId}")
    public String addLike(@PathVariable Long postId, @PathVariable Long userId) {
        User userById = userService.findUserById(UserController.currentUser.getId());
        likeService.addLikes(userById.getId(), postId);
        return "redirect:/post/myPost/" + userId;
    }
}
