package fit.nlu.dao;

import fit.nlu.dao.impl.HoaDonImpl;
import fit.nlu.entity.HoaDon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAO implements HoaDonImpl {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public int ThemHoaDon(HoaDon hoaDon) {
        Session session = sessionFactory.getCurrentSession();
        int id = (int) session.save(hoaDon);
        if (id > 0) {
            return 1;
        }
        return 0;
    }
}
