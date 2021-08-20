package fit.nlu.dao;

import fit.nlu.dao.impl.SanPhamImpl;
import fit.nlu.entity.SanPham;
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
public class SanPhamDAO implements SanPhamImpl {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<SanPham> LayDanhSachSanPhamLimit(int spbatdau) {
        Session session = sessionFactory.getCurrentSession();
        List<SanPham> list = session.createQuery("from SanPham").setFirstResult(spbatdau).setMaxResults(20).getResultList();
        return list;
    }

    @Override
    @Transactional
    public SanPham LayDanhSachChiTietSanPhamTheoMa(int id) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "from SanPham where masanpham=" + id;
        SanPham sanPham = (SanPham) session.createQuery(sql).uniqueResult();
        return sanPham;
    }
}
