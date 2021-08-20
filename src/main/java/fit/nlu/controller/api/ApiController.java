package fit.nlu.controller.api;

import fit.nlu.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@SessionAttributes("user")
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

}
