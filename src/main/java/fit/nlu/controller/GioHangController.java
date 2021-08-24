package fit.nlu.controller;

import fit.nlu.entity.ChiTietHoaDon;
import fit.nlu.entity.ChiTietHoaDonId;
import fit.nlu.entity.HoaDon;
import fit.nlu.service.ChiTietHoaDonService;
import fit.nlu.service.HoaDonService;
import fit.nlu.utils.GioHang;
import fit.nlu.utils.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/giohang")
public class GioHangController {

    @Autowired
    private Session session;

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;

    @GetMapping
    public String Default(HttpSession httpSession, ModelMap modelMap) {
        session.getSeassion(httpSession, modelMap);
        List<GioHang> gioHangList = (List<GioHang>) httpSession.getAttribute("giohang");
        modelMap.addAttribute("listgiohang", gioHangList);
        return "web/giohang";
    }

    @PostMapping
    public String ThemHoaDon(HttpSession httpSession, @RequestParam String tenkhachhang, @RequestParam String sdt, @RequestParam String diachigiaohang, @RequestParam String hinhthucgiaohang, @RequestParam String ghichu) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/login";
        } else {
            if (null != httpSession.getAttribute("giohang")) {
                HoaDon hoaDon = new HoaDon();
                List<GioHang> gioHangList = (List<GioHang>) httpSession.getAttribute("giohang");
                hoaDon.setTenkhachhang(tenkhachhang);
                hoaDon.setSodienthoai(sdt);
                hoaDon.setDiachigiaohang(diachigiaohang);
                hoaDon.setHinhthucgiaohang(hinhthucgiaohang);
                hoaDon.setNgaylap("22/8/2021");
                hoaDon.setTinhtrang(false);
                hoaDon.setGhichu(ghichu);

                int id = hoaDonService.ThemHoaDon(hoaDon);

                if (id > 0) {
                    for (GioHang gioHang : gioHangList) {
                        ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
                        chiTietHoaDonId.setMachitiethoadon(gioHang.getMachitiet());
                        chiTietHoaDonId.setMahoadon(hoaDon.getMahoadon());

                        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                        chiTietHoaDon.setChiTietHoaDonId(chiTietHoaDonId);

                        chiTietHoaDon.setGiatien(gioHang.getGiaTien());
                        chiTietHoaDon.setSoluong(gioHang.getSoLuong());

                        chiTietHoaDonService.Themchitiethoadon(chiTietHoaDon);
                        httpSession.removeAttribute("giohang");
                    }
                }
            }
            return "/web/giohang";
        }
    }
}