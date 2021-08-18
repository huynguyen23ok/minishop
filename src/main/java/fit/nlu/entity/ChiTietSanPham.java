package fit.nlu.entity;

import javax.persistence.*;

@Entity
@Table(name = "chitietsanpham")
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int machitietsanpham;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "masanpham")
    private SanPham sanPham;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "masize")
    private SizeSanPham sizeSanPham;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mamau")
    private MauSanPham mauSanPham;

    private int soluong;

    private String ngaynhap;

    public int getMachitietsanpham() {
        return machitietsanpham;
    }

    public void setMachitietsanpham(int machitietsanpham) {
        this.machitietsanpham = machitietsanpham;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public SizeSanPham getSizeSanPham() {
        return sizeSanPham;
    }

    public void setSizeSanPham(SizeSanPham sizeSanPham) {
        this.sizeSanPham = sizeSanPham;
    }

    public MauSanPham getMauSanPham() {
        return mauSanPham;
    }

    public void setMauSanPham(MauSanPham mauSanPham) {
        this.mauSanPham = mauSanPham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
}
