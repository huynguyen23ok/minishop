package fit.nlu.autho;

import fit.nlu.entity.NhanVien;
import fit.nlu.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private NhanVienService nhanVienServicel;

    @GetMapping
    public String Default() {
        return "login";
    }

    @PostMapping
    public String DangKy(@RequestParam String userre, @RequestParam String passwordRe, @RequestParam String repassword, ModelMap modelMap) {
        if (passwordRe.equals(repassword)) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setTendangnhap(userre);
            nhanVien.setMatkhau(passwordRe);
            boolean kt = nhanVienServicel.save(nhanVien);
            if (kt) {
                modelMap.addAttribute("kiemtra", "Tạo tài khoản thành công");
            } else {
                modelMap.addAttribute("kiemtra", "Tạo tài khoản thất bại");
            }
        } else {
            modelMap.addAttribute("kiemtra", "Mật khẩu không trùng nhau");
        }
        return "login";
    }
}
