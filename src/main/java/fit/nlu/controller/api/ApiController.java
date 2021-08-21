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
        if (session.getAttribute("giohang") == null) {
            list.add(gioHang);
            session.setAttribute("giohang", list);
            System.out.println(gioHang.getTenSp() + "-" + gioHang.getMaMau() + "-" + gioHang.getTenSize() + "-" + gioHang.getSoLuong());
        } else {
            int vitri = KiemtraSanpham(gioHang.getMaSP(), gioHang.getMaSize(), gioHang.getMaMau(), session);
            if (vitri == -1) {
                list = (List<GioHang>) session.getAttribute("giohang");
                list.add(gioHang);
                System.out.println(gioHang.getTenSp() + "-" + gioHang.getMaMau() + "-" + gioHang.getTenSize() + "-" + gioHang.getSoLuong());
            } else {
                list = (List<GioHang>) session.getAttribute("giohang");
                int num = list.get(vitri).getSoLuong() + 1;
                list.get(vitri).setSoLuong(num);
                System.out.println(gioHang.getTenSp() + "-" + gioHang.getMaMau() + "-" + gioHang.getTenSize() + "-" + gioHang.getSoLuong());
            }
        }
    }

    private int KiemtraSanpham(int masp, int masize, int mamau, HttpSession session) {
        List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaSP() == masp && list.get(i).getMaSize() == mamau && list.get(i).getMaMau() == mamau) {
                return 1;
            }
        }
        return -1;
    }

}
