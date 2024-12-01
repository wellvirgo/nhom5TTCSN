package com.nhom5_TTCSN.QuanLyKhachSan.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maTaiKhoan;
    private String tenTaiKhoan;
    private String matKhau;
    private String vaiTro;

    @OneToOne(mappedBy = "taiKhoan")
    private NguoiQuanLy nguoiQuanLy;

    @OneToOne(mappedBy = "taiKhoan")
    private NhanVien nhanVien;

    public long getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(long maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public NguoiQuanLy getNguoiQuanLy() {
        return nguoiQuanLy;
    }

    public void setNguoiQuanLy(NguoiQuanLy nguoiQuanLy) {
        this.nguoiQuanLy = nguoiQuanLy;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

}
