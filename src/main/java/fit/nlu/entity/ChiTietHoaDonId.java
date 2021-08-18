package fit.nlu.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChiTietHoaDonId implements Serializable {

    private int mahoadon;

    private int machitiethoadon;

    public int getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }

    public int getMachitiethoadon() {
        return machitiethoadon;
    }

    public void setMachitiethoadon(int machitiethoadon) {
        this.machitiethoadon = machitiethoadon;
    }
}
