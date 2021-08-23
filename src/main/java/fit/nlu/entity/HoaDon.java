package fit.nlu.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hoadon")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mahoadon;

    private String tenkhachhang;

    private String sodienthoai;

    private String diachigiaohang;

    private Boolean tinhtrang;

    private String ngaylap;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mahoadon")
    private Set<ChiTietHoaDon> danhsachchitiethoadon;

    private String hinhthucgiaohang;

    private String ghichu;

    public int getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiachigiaohang() {
        return diachigiaohang;
    }

    public void setDiachigiaohang(String diachigiaohang) {
        this.diachigiaohang = diachigiaohang;
    }

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public Set<ChiTietHoaDon> getDanhsachchitiethoadon() {
        return danhsachchitiethoadon;
    }

    public void setDanhsachchitiethoadon(Set<ChiTietHoaDon> danhsachchitiethoadon) {
        this.danhsachchitiethoadon = danhsachchitiethoadon;
    }

    public String getHinhthucgiaohang() {
        return hinhthucgiaohang;
    }

    public void setHinhthucgiaohang(String hinhthucgiaohang) {
        this.hinhthucgiaohang = hinhthucgiaohang;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
