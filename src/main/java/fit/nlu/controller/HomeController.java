package fit.nlu.controller;

import fit.nlu.entity.SanPham;
import fit.nlu.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private SanPhamService service;

    @GetMapping
    public String Default(ModelMap modelMap, HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) {
            modelMap.addAttribute("taikhoan", httpSession.getAttribute("user"));
        }
        List<SanPham> list = service.LayDanhSachSanPhamLimit(0);
        modelMap.addAttribute("listSanpham", list);
        return "web/index";
    }


}
