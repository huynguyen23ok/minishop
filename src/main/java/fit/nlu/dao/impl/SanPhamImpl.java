package fit.nlu.dao.impl;

import fit.nlu.entity.SanPham;

import java.util.List;

public interface SanPhamImpl {
    List<SanPham> LayDanhSachSanPhamLimit(int spbatdau);

    SanPham LayDanhSachChiTietSanPhamTheoMa(int id);

    List<SanPham> LaySanPhamTheoDanhMuc(int id);
}
