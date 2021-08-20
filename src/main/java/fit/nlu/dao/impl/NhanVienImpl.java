package fit.nlu.dao.impl;

import fit.nlu.entity.NhanVien;

public interface NhanVienImpl {

    boolean KiemTraDangNhap(String email, String matkhau);

    boolean save(NhanVien nhanVien);
}
