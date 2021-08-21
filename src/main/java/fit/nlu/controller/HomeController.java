package fit.nlu.controller;

import fit.nlu.entity.SanPham;
import fit.nlu.service.SanPhamService;
import fit.nlu.utils.GioHang;
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
@SessionAttributes({"user", "giohang"})
public class HomeController {

    @Autowired
    private SanPhamService service;

    @GetMapping
    public String Default(ModelMap modelMap, HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) {
            modelMap.addAttribute("taikhoan", httpSession.getAttribute("user"));
        }
        if (null != httpSession.getAttribute("giohang")) {
            List<GioHang> gioHangList = (List<GioHang>) httpSession.getAttribute("giohang");
            modelMap.addAttribute("soluong", gioHangList.size());
        }
        List<SanPham> list = service.LayDanhSachSanPhamLimit(0);
        modelMap.addAttribute("listSanpham", list);
        return "web/index";
    }


}
