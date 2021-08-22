package fit.nlu.controller;

import fit.nlu.utils.GioHang;
import fit.nlu.utils.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/giohang")
public class GioHangController {

    @Autowired
    private Session session;

    @GetMapping
    public String Default(HttpSession httpSession, ModelMap modelMap) {
        session.getSeassion(httpSession, modelMap);
        List<GioHang> gioHangList = (List<GioHang>) httpSession.getAttribute("giohang");
        modelMap.addAttribute("listgiohang", gioHangList);
        return "web/giohang";
    }
}
