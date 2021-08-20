package fit.nlu.dao;

import fit.nlu.dao.impl.NhanVienImpl;
import fit.nlu.entity.NhanVien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhanVienDAO implements NhanVienImpl {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean KiemTraDangNhap(String tendangnhap, String matkhau) {
        Session session = sessionFactory.getCurrentSession();
        try {
            NhanVien nhanVien = (NhanVien) session.createQuery("from NhanVien where tendangnhap='" + tendangnhap + "' and matkhau='" + matkhau + "'").uniqueResult();
            if (nhanVien != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean save(NhanVien nhanVien) {
        Session session = sessionFactory.getCurrentSession();
        int manhanvien = (int) session.save(nhanVien);
        if (manhanvien > 0) {
            return true;
        } else {
            return false;
        }
    }
}
