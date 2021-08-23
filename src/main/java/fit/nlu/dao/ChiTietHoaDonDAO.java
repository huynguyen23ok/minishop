package fit.nlu.dao;

import fit.nlu.dao.impl.ChiTietHoaDonImpl;
import fit.nlu.entity.ChiTietHoaDon;
import fit.nlu.entity.ChiTietHoaDonId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDAO implements ChiTietHoaDonImpl {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean Themchitiethoadon(ChiTietHoaDon chiTietHoaDon) {
        Session session = sessionFactory.getCurrentSession();
        ChiTietHoaDonId id = (ChiTietHoaDonId) session.save(chiTietHoaDon);
        if (null != id) {
            return true;
        }
        return false;
    }
}
