package fit.nlu.dao;

import fit.nlu.dao.impl.DanhMucImpl;
import fit.nlu.entity.DanhMucSanPham;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDAO implements DanhMucImpl {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<DanhMucSanPham> layDanhMuc() {
        Session session = sessionFactory.getCurrentSession();
        List<DanhMucSanPham> list = session.createQuery("from DanhMucSanPham ").getResultList();
        return list;
    }
}
