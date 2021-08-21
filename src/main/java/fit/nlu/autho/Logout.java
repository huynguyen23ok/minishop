package fit.nlu.autho;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class Logout {

    @GetMapping
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }
}
