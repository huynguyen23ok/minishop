package fit.nlu.controller;

import fit.nlu.entity.DanhMucSanPham;
import fit.nlu.entity.SanPham;
import fit.nlu.service.DanhMucService;
import fit.nlu.service.SanPhamService;
import fit.nlu.utils.GioHang;
import fit.nlu.utils.Session;
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

    @Autowired
    private Session session;
    @Autowired
    private DanhMucService danhMucService;

    @GetMapping
    public String Default(ModelMap modelMap, HttpSession httpSession) {
        session.getSeassion(httpSession, modelMap);
        List<SanPham> list = service.LayDanhSachSanPhamLimit(0);
        List<DanhMucSanPham> listdanhmuc = danhMucService.layDanhMuc();
        modelMap.addAttribute("listSanpham", list);
        modelMap.addAttribute("listDanhmuc", listdanhmuc);
        return "web/index";
    }


}
