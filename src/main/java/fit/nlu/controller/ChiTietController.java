package fit.nlu.controller;

import fit.nlu.entity.DanhMucSanPham;
import fit.nlu.entity.SanPham;
import fit.nlu.service.DanhMucService;
import fit.nlu.service.SanPhamService;
import fit.nlu.utils.Session;
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
public class ChiTietController {

    @Autowired
    private SanPhamService service;

    @Autowired
    private DanhMucService danhMucService;

    @Autowired
    private Session session;

    @GetMapping("/{id}")
    public String Defaul(ModelMap modelMap, @PathVariable int id, HttpSession httpSession) {
        session.getSeassion(httpSession, modelMap);
        SanPham sanPham = service.LayDanhSachChiTietSanPhamTheoMa(id);
        List<DanhMucSanPham> list = danhMucService.layDanhMuc();
        modelMap.addAttribute("chitietsanpham", sanPham);
        modelMap.addAttribute("listDanhmuc", list);
        return "web/chitiet";
    }
}
