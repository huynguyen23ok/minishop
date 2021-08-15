package fit.nlu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String Default() {
        return "/decorators/login.jsp";
    }

    @PostMapping
    public String Login(@RequestParam String user, @RequestParam String pass) {
        if (user.equals("huy") && pass.equals("1234")) {
            return "redirect:/";
        } else {
            return "/decorators/login.jsp";
        }
    }

}
