package fit.nlu.controller.api;

import fit.nlu.service.NhanVienService;
import fit.nlu.utils.GioHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
@SessionAttributes({"user", "giohang"})
public class ApiController {

    List<GioHang> list = new ArrayList<>();

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/checklogin")
    @ResponseBody
    public String checkLogin(@RequestParam String user, @RequestParam String password, ModelMap modelMap) {
        boolean check = nhanVienService.KiemTraDangNhap(user, password);
        modelMap.addAttribute("user", user);
        return "" + check;
    }

    @GetMapping("/addSanpham")
    @ResponseBody
    public void themGioHang(@ModelAttribute GioHang gioHang, HttpSession session) {
        list.add(gioHang);
        session.setAttribute("giohang", list);
        List<GioHang> gioHangList = (List<GioHang>) session.getAttribute("giohang");
        System.out.println(gioHang.getMasize() + "-" + gioHangList);
    }


}
