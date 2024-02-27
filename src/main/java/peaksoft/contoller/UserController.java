package peaksoft.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.User;
import peaksoft.service.UserInfoService;
import peaksoft.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
   private final UserService userService;

   public static User currentUser;
   @GetMapping("/new")
   public String signUpp(Model model){
       model.addAttribute("newUser",new User());
       return "sign-up";
   }
   @PostMapping("/save")
   public String saveUpUser(@ModelAttribute("newUser") User newUser){
      currentUser = userService.sigUp(newUser);
       return "/registerUser";
   }
    @GetMapping("/neww")
    public String signInn( Model model){
        model.addAttribute("uuser", new User());
        return "sign-in";
    }
    @PostMapping("/signIn")
    public String signIn(@ModelAttribute("uuser") User user, Model model){
       try{
           currentUser = userService.signIn(user.getUserName(), user.getPassword());
           if(currentUser != null){
               model.addAttribute("currentUser", userService.findUserById(currentUser.getId()));
               model.addAttribute("allUsers",userService.getAllUsers());
               return "registerUser";
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
       return "redirect:/user/neww";

    }
    @GetMapping("/profile")                    //homePage den profilege otuu uchun
    public String profile(Model model){
       model.addAttribute("currentUser", currentUser);
       model.addAttribute("currUserId", currentUser.getId());
       return "profilePage";
    }


    @GetMapping("/home")
    public String profilePage(Model model){
       model.addAttribute("currentUser",
               userService.findUserById(currentUser.getId()));
       return "registerUser";
    }

    @PostMapping("/homeInfo")
    public String HomePage(@ModelAttribute("currentUser")User user){
       return "/registerUser";
    }

    @GetMapping("/search/{userId}")
    public String findUser(Model model,@PathVariable Long userId){
       model.addAttribute("userId",userId);
       model.addAttribute("allUsers",userService.getAllUsers());
       return "searchPage";
    }

    @GetMapping("/searchUser/{userId}")
    public String searchUser(Model model,@RequestParam String keyword,@PathVariable Long userId){
        model.addAttribute("userId",userId);
        try {
            model.addAttribute( "currentUser",userService.findUserByUserName(keyword));
            return "profSearchUser";
        } catch (Exception e) {
            return "redirect:/user/profile";
        }
    }

//
//    @GetMapping("/searchClick")
//    public String searchUser() {
//       return "/profSearchUser";
//    }
//
//    @PostMapping("/userProf")
//    public String user(){
//       return "/profSearchUser";
//    }

}
