package fit.nlu.service;

import fit.nlu.dao.SanPhamDAO;
import fit.nlu.dao.impl.SanPhamImpl;
import fit.nlu.entity.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService implements SanPhamImpl {

    @Autowired
    private SanPhamDAO sanPhamDAO;

    @Override
    public List<SanPham> LayDanhSachSanPhamLimit(int spbatdau) {
        return sanPhamDAO.LayDanhSachSanPhamLimit(spbatdau);
    }

    @Override
    public SanPham LayDanhSachChiTietSanPhamTheoMa(int id) {
        return sanPhamDAO.LayDanhSachChiTietSanPhamTheoMa(id);
    }
}
