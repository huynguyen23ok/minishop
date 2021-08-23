package fit.nlu.service;

import fit.nlu.dao.ChiTietHoaDonDAO;
import fit.nlu.dao.impl.ChiTietHoaDonImpl;
import fit.nlu.entity.ChiTietHoaDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonService implements ChiTietHoaDonImpl {

    @Autowired
    private ChiTietHoaDonDAO chiTietHoaDonDAO;

    @Override
    public boolean Themchitiethoadon(ChiTietHoaDon chiTietHoaDon) {
        return chiTietHoaDonDAO.Themchitiethoadon(chiTietHoaDon);
    }
}
