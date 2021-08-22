package fit.nlu.controller.api;

import fit.nlu.service.NhanVienService;
import fit.nlu.utils.GioHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@SessionAttributes({"user", "giohang"})
public class ApiController {

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
    public String themGioHang(@ModelAttribute GioHang gioHang, HttpSession session, ModelMap modelMap) {
        if (null == session.getAttribute("giohang")) {
            List<GioHang> gioHangList = new ArrayList<>();
            gioHangList.add(gioHang);
            session.setAttribute("giohang", gioHangList);
            modelMap.addAttribute("soluong", gioHangList.size());
            return gioHangList.size() + "";
        } else {
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            int vitri = KiemtraSanpham(gioHang.getMaSP(), gioHang.getMaSize(), gioHang.getMaMau(), session);
            if (vitri == -1) {
                list.add(gioHang);
            } else {
                list = (List<GioHang>) session.getAttribute("giohang");
                list.get(vitri).setSoLuong(gioHang.getSoLuong() + 1);
            }
            modelMap.addAttribute("soluong", list.size());
            return list.size() + "";
        }
    }

    private int KiemtraSanpham(int masp, int masize, int mamau, HttpSession session) {
        List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaSP() == masp && list.get(i).getMaSize() == masize && list.get(i).getMaMau() == mamau) {
                return i;
            }
        }
        return -1;
    }

//    @GetMapping("/number")
//    @ResponseBody
//    public String LaySoLuong(HttpSession session) {
//        if (null != session.getAttribute("giohang")) {
//            List<GioHang> gioHangList = (List<GioHang>) session.getAttribute("giohang");
//            return gioHangList.size() + "";
//        }
//        return null;
//    }

    @GetMapping("/updateGioHang")
    @ResponseBody
    public void updateGioHang(HttpSession session, int soluong) {
        if (null != session.getAttribute("giohang")) {

        }
    }

}
