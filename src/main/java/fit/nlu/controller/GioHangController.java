package fit.nlu.controller;

import fit.nlu.utils.GioHang;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/giohang")
@SessionAttributes({"user", "giohang"})
public class GioHangController {

    @GetMapping
    public String Default(HttpSession session, ModelMap modelMap) {
        List<GioHang> gioHangList = (List<GioHang>) session.getAttribute("giohang");
        modelMap.addAttribute("listgiohang", gioHangList);
        return "web/giohang";
    }
}
