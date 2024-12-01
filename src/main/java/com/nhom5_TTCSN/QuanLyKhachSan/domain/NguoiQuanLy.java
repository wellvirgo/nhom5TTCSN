package com.nhom5_TTCSN.QuanLyKhachSan.domain;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class NguoiQuanLy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maQuanLy;
    private String tenQuanLy;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private String gioiTinh;
    private Date ngaySinh;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maTaiKhoan")
    private TaiKhoan taiKhoan;

    public long getMaQuanLy() {
        return maQuanLy;
    }

    public void setMaQuanLy(long maQuanLy) {
        this.maQuanLy = maQuanLy;
    }

    public String getTenQuanLy() {
        return tenQuanLy;
    }

    public void setTenQuanLy(String tenQuanLy) {
        this.tenQuanLy = tenQuanLy;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

}
