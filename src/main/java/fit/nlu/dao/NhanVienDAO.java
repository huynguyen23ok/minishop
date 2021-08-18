package fit.nlu.dao;

import fit.nlu.dao.impl.NhanVienImpl;
import fit.nlu.entity.NhanVien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class NhanVienDAO implements NhanVienImpl {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean KiemTraDangNhap(String email, String matkhau) {
        Session session = sessionFactory.getCurrentSession();
        try {
            NhanVien nhanVien = (NhanVien) session.createQuery("from NhanVien where email ='" + email + "' and matkhau='" + matkhau + "'").getResultList();
            if (nhanVien != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
