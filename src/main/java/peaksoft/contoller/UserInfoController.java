package peaksoft.contoller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.UserInfo;
import peaksoft.service.UserInfoService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/userInfo")
public class UserInfoController {
    private final UserInfoService userInfoService;


    @GetMapping("/update/{userInfoId}/{userId}")
    public String update(Model model,
                         @PathVariable("userInfoId") Long userInfoId,
                         @PathVariable("userId") Long userId) {
        model.addAttribute("userInfo", new UserInfo());
        model.addAttribute("userInfoId", userInfoId);
        model.addAttribute("userId", userId);
        return "/userInfos";
    }

    @PostMapping("/fullInfo/{userInfoId}/{userId}")
    public String fullInfo(@ModelAttribute("userInfo") UserInfo userInfo,
                           @PathVariable("userInfoId") Long userInfoId
                         ){
        userInfoService.update(userInfoId, userInfo);
        return "redirect:/user/profile";
    }
}
