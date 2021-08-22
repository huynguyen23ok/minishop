package fit.nlu.utils;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component
@SessionAttributes({"user", "giohang"})
public class Session {

    public void getSeassion(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("user") != null) {
            modelMap.addAttribute("taikhoan", session.getAttribute("user"));
        }
        if (session.getAttribute("giohang") != null) {
            List<GioHang> gioHangList = (List<GioHang>) session.getAttribute("giohang");
            modelMap.addAttribute("soluong", gioHangList.size());
        }
    }
}
