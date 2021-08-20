package fit.nlu.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sanpham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int masanpham;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "madanhmuc")
    private DanhMucSanPham danhMucSanPham;

    private String tensanpham;

    private String giatien;

    private String mota;

    private String hinhsanpham;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "masanpham")
    private Set<ChiTietSanPham> chiTietSanPhamSet;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "chitietkhuyenmai",
            joinColumns = {@JoinColumn(name = "masanpham", referencedColumnName = "masanpham")},
            inverseJoinColumns = {@JoinColumn(name = "makhuyenmai", referencedColumnName = "makhuyenmai")})
    private Set<KhuyenMai> danhsachkhuyenmai;

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public DanhMucSanPham getDanhMucSanPham() {
        return danhMucSanPham;
    }

    public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
        this.danhMucSanPham = danhMucSanPham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhsanpham() {
        return hinhsanpham;
    }

    public void setHinhsanpham(String hinhsanpham) {
        this.hinhsanpham = hinhsanpham;
    }

    public Set<ChiTietSanPham> getChiTietSanPhamSet() {
        return chiTietSanPhamSet;
    }

    public void setChiTietSanPhamSet(Set<ChiTietSanPham> chiTietSanPhamSet) {
        this.chiTietSanPhamSet = chiTietSanPhamSet;
    }

    public Set<KhuyenMai> getDanhsachkhuyenmai() {
        return danhsachkhuyenmai;
    }

    public void setDanhsachkhuyenmai(Set<KhuyenMai> danhsachkhuyenmai) {
        this.danhsachkhuyenmai = danhsachkhuyenmai;
    }
}
