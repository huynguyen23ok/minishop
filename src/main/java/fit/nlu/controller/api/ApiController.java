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


    @GetMapping("/updateGioHang")
    @ResponseBody
    public void updateGioHang(HttpSession session, @RequestParam int soluong, @RequestParam int masp, @RequestParam int masize, @RequestParam int mamau) {
        if (null != session.getAttribute("giohang")) {
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            int vitri = KiemtraSanpham(masp, masize, mamau, session);
            list.get(vitri).setSoLuong(soluong);
        }
    }

    @GetMapping("/delete")
    @ResponseBody
    public void remove(HttpSession session, @RequestParam int masp, @RequestParam int masize, @RequestParam int mamau) {
        if (null != session.getAttribute("giohang")) {
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            int vitri = KiemtraSanpham(masp, masize, mamau, session);
            list.remove(vitri);
        }
    }
}
