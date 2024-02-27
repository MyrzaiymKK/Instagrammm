package peaksoft.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Post;
import peaksoft.service.PostService;

import java.lang.reflect.Field;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final PostService postService;
    @GetMapping("/allPostss")
    public String allPost(){
        postService.getAllPosts();
        return "redirect:/registerUser";
    }

}
