package fit.nlu.service;

import fit.nlu.dao.HoaDonDAO;
import fit.nlu.dao.impl.HoaDonImpl;
import fit.nlu.entity.HoaDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoaDonService implements HoaDonImpl {
    @Autowired
    private HoaDonDAO hoaDonDAO;

    @Override
    public int ThemHoaDon(HoaDon hoaDon) {
        return hoaDonDAO.ThemHoaDon(hoaDon);
    }
}
