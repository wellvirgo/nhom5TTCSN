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
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maHoaDon;
    private Date ngayLap;
    private double tongTien;
    private String trangThaiThanhToan;
    private double thanhToanTruoc;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "maNhanVien")
    private NhanVien nhanVien;
    @OneToOne
    @JoinColumn(name = "maDatPhong")
    private DatPhong datPhong;
    @OneToOne
    @JoinColumn(name = "maThuePhong")
    private ThuePhong thuePhong;
    @ManyToOne
    @JoinColumn(name = "maKhachHang")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "maDoanhThu")
    private DoanhThu doanhThu;

    public long getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(long maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(String trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public DatPhong getDatPhong() {
        return datPhong;
    }

    public void setDatPhong(DatPhong datPhong) {
        this.datPhong = datPhong;
    }

    public ThuePhong getThuePhong() {
        return thuePhong;
    }

    public void setThuePhong(ThuePhong thuePhong) {
        this.thuePhong = thuePhong;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public DoanhThu getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(DoanhThu doanhThu) {
        this.doanhThu = doanhThu;
    }

    public double getThanhToanTruoc() {
        return thanhToanTruoc;
    }

    public void setThanhToanTruoc(double thanhToanTruoc) {
        this.thanhToanTruoc = thanhToanTruoc;
    }

}
