package peaksoft.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class FollowerController {
    private final UserService userService;
    @GetMapping("/follow/{foundUserId}")
    public String addSubscribers(@PathVariable Long foundUserId){
        userService.addFollower(foundUserId);
        return "redirect:/user/profile";
    }
}
