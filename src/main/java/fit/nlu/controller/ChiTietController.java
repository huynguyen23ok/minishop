package fit.nlu.controller;

import fit.nlu.entity.DanhMucSanPham;
import fit.nlu.entity.SanPham;
import fit.nlu.service.DanhMucService;
import fit.nlu.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/chitiet")
@SessionAttributes({"user", "giohang"})
public class ChiTietController {

    @Autowired
    private SanPhamService service;

    @Autowired
    private DanhMucService danhMucService;


    @GetMapping("/{id}")
    public String Defaul(ModelMap modelMap, @PathVariable int id, HttpSession session) {
        SanPham sanPham = service.LayDanhSachChiTietSanPhamTheoMa(id);
        List<DanhMucSanPham> list = danhMucService.layDanhMuc();
        if (session.getAttribute("user") != null) {
            modelMap.addAttribute("taikhoan", session.getAttribute("user"));
        }
        modelMap.addAttribute("chitietsanpham", sanPham);
        modelMap.addAttribute("listDanhmuc", list);
        return "web/chitiet";
    }
}
