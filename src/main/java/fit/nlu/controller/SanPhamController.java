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

import java.util.List;

@Controller
@RequestMapping("/list")
public class SanPhamController {

    @Autowired
    private DanhMucService danhMucService;

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/{id}/{tendanhmuc}")
    public String Default(ModelMap modelMap, @PathVariable int id, @PathVariable String tendanhmuc) {
        List<SanPham> list = sanPhamService.LaySanPhamTheoDanhMuc(id);
        List<DanhMucSanPham> listdanhmuc = danhMucService.layDanhMuc();

        modelMap.addAttribute("danhmuc", tendanhmuc);
        modelMap.addAttribute("listDanhmuc", listdanhmuc);
        modelMap.addAttribute("list", list);
        return "web/list";
    }
}
