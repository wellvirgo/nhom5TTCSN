package com.nhom5_TTCSN.QuanLyKhachSan.domain;

import java.sql.Date;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class ThuePhong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maThuePhong;
    private Date ngayTra;
    private Date ngayNhan;
    private int soNguoi;
    private double tongChiPhi;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "maNhanVien")
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name = "maPhong")
    private Phong phong;
    @ManyToOne
    @JoinColumn(name = "maKhachHang")
    private KhachHang khachHang;

    @OneToOne(mappedBy = "thuePhong")
    private HoaDon hoaDon;

    public long getMaThuPhong() {
        return maThuePhong;
    }

    public void setMaThuPhong(long maThuPhong) {
        this.maThuePhong = maThuPhong;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public double getTongChiPhi() {
        return tongChiPhi;
    }

    public void setTongChiPhi(double tongChiPhi) {
        this.tongChiPhi = tongChiPhi;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public long getMaThuePhong() {
        return maThuePhong;
    }

    public void setMaThuePhong(long maThuePhong) {
        this.maThuePhong = maThuePhong;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

}
