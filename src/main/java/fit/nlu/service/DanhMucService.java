package fit.nlu.service;

import fit.nlu.dao.DanhMucDAO;
import fit.nlu.dao.impl.DanhMucImpl;
import fit.nlu.entity.DanhMucSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucService implements DanhMucImpl {

    @Autowired
    private DanhMucDAO dao;

    @Override
    public List<DanhMucSanPham> layDanhMuc() {
        return dao.layDanhMuc();
    }
}
