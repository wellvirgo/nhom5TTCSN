package com.nhom5_TTCSN.QuanLyKhachSan.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Luong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maLuong;
    private double luongCoBan;
    private double ngayCong;
    private double tongLuong;

    @OneToOne(mappedBy = "luong")
    private NhanVien nhanVien;

    public long getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(long maLuong) {
        this.maLuong = maLuong;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(double ngayCong) {
        this.ngayCong = ngayCong;
    }

    public double getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(double tongLuong) {
        this.tongLuong = tongLuong;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

}
