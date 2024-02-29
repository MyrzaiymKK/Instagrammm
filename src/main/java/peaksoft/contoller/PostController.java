package peaksoft.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Post;
import peaksoft.entity.User;
import peaksoft.service.PostService;
import peaksoft.service.UserService;
import peaksoft.service.impl.PostServiceImpl;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @GetMapping("/postClick/{userId}")
    public String savePost(Model model,
                           @PathVariable("userId")Long userId)
    {
        model.addAttribute("newPost", new Post());
        model.addAttribute("userId",userId);
        return "newPost";
    }
    @PostMapping("/fullPost/{userId}")
    public String fullPost(@ModelAttribute("newPost") Post post,
                           @PathVariable("userId") Long userId){
        postService.savePost(userId, post);
        return "redirect:/user/profile";
    }
    @GetMapping("/myPost/{userId}")
    public String allPost(Model model,
                          @PathVariable("userId")Long userId){
      model.addAttribute("myPost",postService.getUserPost(userId));
      model.addAttribute("userId", userId);
        return "/myPosts";
    }

    @GetMapping("/updateClick/{postId}")
    public String updatePost(@PathVariable("postId")Long postId,Model model){
        Post post = postService.findPostById(postId);
        model.addAttribute("post",post);
        return "/updatePost";
    }

    @PostMapping("/updatePostt/{postId}")
    public String updatePostt(@ModelAttribute("post")Post post,
                              @PathVariable("postId")Long postId){
        postService.update(postId,post);
        return "/myPosts";
    }


}
