package fit.nlu.controller;

import fit.nlu.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public String Default() {
        return "login";
    }

    @PostMapping
    public String XulyDangnhap(@RequestParam String user, @RequestParam String password) {
        boolean check = nhanVienService.KiemTraDangNhap(user, password);
        if (check == true) {
            System.out.println("access");
        } else {
            System.out.println("fail");
        }
        return "login";
    }

}
