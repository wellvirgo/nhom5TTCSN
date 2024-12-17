package com.nhom5_TTCSN.QuanLyKhachSan.domain;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "nhan_vien", uniqueConstraints = @UniqueConstraint(columnNames = { "soCMND" }))
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maNhanVien;
    private String tenNhanVien;
    private String soCMND;
    private String soDienThoai;
    private String email;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String chucVu;
    private String caLam;
    private String linkAnhNhanVien;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatPhong> datPhongs;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ThuePhong> thuePhongs;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maLuong")
    private Luong luong;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maTaiKhoan")
    private TaiKhoan taiKhoan;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HoaDon> hoaDons;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    private List<NgayLam> ngayLams;

    public long getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(long maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public Luong getLuong() {
        return luong;
    }

    public void setLuong(Luong luong) {
        this.luong = luong;
    }

    public String getCaLam() {
        return caLam;
    }

    public void setCaLam(String caLam) {
        this.caLam = caLam;
    }

    public List<DatPhong> getDatPhong() {
        return datPhongs;
    }

    public void setDatPhong(List<DatPhong> datPhong) {
        this.datPhongs = datPhong;
    }

    public String getLinkAnhNhanVien() {
        return linkAnhNhanVien;
    }

    public void setLinkAnhNhanVien(String linkAnhNhanVien) {
        this.linkAnhNhanVien = linkAnhNhanVien;
    }

    public List<DatPhong> getDatPhongs() {
        return datPhongs;
    }

    public void setDatPhongs(List<DatPhong> datPhongs) {
        this.datPhongs = datPhongs;
    }

    public List<ThuePhong> getThuePhongs() {
        return thuePhongs;
    }

    public void setThuePhongs(List<ThuePhong> thuePhongs) {
        this.thuePhongs = thuePhongs;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    public List<NgayLam> getNgayLams() {
        return ngayLams;
    }

    public void setNgayLams(List<NgayLam> ngayLams) {
        this.ngayLams = ngayLams;
    }

}
