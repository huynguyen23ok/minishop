package fit.nlu.entity;

import javax.persistence.*;

@Entity
@Table(name = "sizesanpham")
public class SizeSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int masize;

    private String size;

    public int getMasize() {
        return masize;
    }

    public void setMasize(int masize) {
        this.masize = masize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
