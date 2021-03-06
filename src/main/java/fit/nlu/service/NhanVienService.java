package fit.nlu.service;


import fit.nlu.dao.NhanVienDAO;
import fit.nlu.dao.impl.NhanVienImpl;
import fit.nlu.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienService implements NhanVienImpl {

    @Autowired
    private NhanVienDAO nhanVienDAO;

    @Override
    public boolean KiemTraDangNhap(String email, String matkhau) {
        boolean check = nhanVienDAO.KiemTraDangNhap(email, matkhau);
        return check;
    }

    @Override
    public boolean save(NhanVien nhanVien) {
        boolean save = nhanVienDAO.save(nhanVien);
        return save;
    }
}
