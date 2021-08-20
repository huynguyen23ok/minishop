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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/chitiet")
public class ChiTiet {

    @Autowired
    private SanPhamService service;

    @Autowired
    private DanhMucService danhMucService;

    @GetMapping("/{id}")
    public String Defaul(ModelMap modelMap, HttpSession httpSession, @PathVariable int id) {
        if (httpSession.getAttribute("user") != null) {
            modelMap.addAttribute("taikhoan", httpSession.getAttribute("user"));
        }
        SanPham sanPham = service.LayDanhSachChiTietSanPhamTheoMa(id);
        modelMap.addAttribute("chitietsanpham", sanPham);

        List<DanhMucSanPham> list = danhMucService.layDanhMuc();
        modelMap.addAttribute("listDanhmuc", list);

        return "web/chitiet";
    }
}
